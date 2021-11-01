package br.com.lucasbertoloto.registradordecalculos.controller;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;

@Controller
@RequestMapping("/calculos")
public class CalculoController {
    @Autowired
    private CalculoService calculoService;

    @GetMapping
    public ResponseEntity<List<Calculo>> list(){
        if (calculoService.count()<1) {
            return new ResponseEntity<List<Calculo>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Calculo>>(calculoService.findAll(),HttpStatus.OK);
    }
//
//    @PostMapping
//    public ResponseEntity<List<Calculo>> insertCalculos(@RequestBody List<Calculo> calculos){
//        AtomicReference<Boolean> valid = new AtomicReference<>(true);
//        calculos.forEach(calculo -> {
//            if(Objects.isNull(calculo.getNomePessoa()) || Objects.isNull(calculo.getOperacao())
//                    || Objects.isNull(calculo.getResultado())) {
//                valid.set(false);
//            }
//        });
//        if (!valid.get()) {
//            return new ResponseEntity<List<Calculo>>(calculos,HttpStatus.BAD_REQUEST);
//        }
//        return new ResponseEntity<List<Calculo>>(calculoService.insertList(calculos),HttpStatus.OK);
//    }

    @PostMapping
    public ResponseEntity<String> insertCalculo(@RequestBody Calculo calculo){
        if(Objects.isNull(calculo))
            return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
        calculo.calc();
        return new ResponseEntity<String>(Double.toString(calculoService.save(calculo).getResultado())
                ,HttpStatus.OK);
    }
}
