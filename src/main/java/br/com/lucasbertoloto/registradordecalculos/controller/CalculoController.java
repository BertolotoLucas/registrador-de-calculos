package br.com.lucasbertoloto.registradordecalculos.controller;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<Calculo>> list(@RequestParam Map<String,String> allParams){
        if (calculoService.count()<1) {
            return new ResponseEntity<List<Calculo>>(HttpStatus.NO_CONTENT);
        }
        List<Calculo> calculos = new ArrayList<>();
        if (!allParams.isEmpty()) {
            System.out.println(allParams.entrySet());
            if (allParams.containsKey("nomePessoa")) {
                calculos = calculoService.findByNomePessoaContainingIgnoreCase(allParams.get("nomePessoa").toString());
            }
        } else {
            calculos = calculoService.findAll();
        }
        return new ResponseEntity<List<Calculo>>(calculos,HttpStatus.OK);
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
