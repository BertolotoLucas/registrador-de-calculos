package br.com.lucasbertoloto.registradordecalculos.controller;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.repository.CalculoRepository;
import br.com.lucasbertoloto.registradordecalculos.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequestMapping("/calculos")
public class CalculoController {
    @Autowired
    private CalculoService calculoService;

    @GetMapping
    public ResponseEntity<?> list(@RequestParam(required = false) String nomePessoa,
                                  @RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "7") int size){
        Long total = calculoService.count();
        if (total<1) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        try {
            List<Calculo> calculos = new ArrayList<Calculo>();
            Pageable pageable = PageRequest.of(page, size);

            Page<Calculo> pageCalculos;
            if (nomePessoa == null)
                pageCalculos = calculoService.findAll(pageable);
            else
                pageCalculos = calculoService.findByNomePessoaContainingIgnoreCase(nomePessoa,pageable);;

            calculos = pageCalculos.getContent();

            Map<String, Object> response = new HashMap<>();
            response.put("calculos", calculos);
            response.put("currentPage", pageCalculos.getNumber());
            response.put("totalItems", pageCalculos.getTotalElements());
            response.put("totalPages", pageCalculos.getTotalPages());

            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<Calculo> insertCalculo(@RequestBody Calculo calculo){
        if(Objects.isNull(calculo))
            return new ResponseEntity<Calculo>(HttpStatus.BAD_REQUEST);
        calculo.calc();
        return new ResponseEntity<Calculo>(calculoService.save(calculo)
                ,HttpStatus.OK);
    }
}
