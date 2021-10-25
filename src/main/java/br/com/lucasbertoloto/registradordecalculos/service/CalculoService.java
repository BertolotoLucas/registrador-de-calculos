package br.com.lucasbertoloto.registradordecalculos.service;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.repository.CalculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculoService {
    @Autowired
    CalculoRepository calculoRepository;

    public List<Calculo> saveAll(List<Calculo> calculos){
        return calculoRepository.saveAll(calculos);
    }

    public List<Calculo> findAll(){
        return calculoRepository.findAll();
    }

    public List<Calculo> insertList(List<Calculo> calculos){
        return calculoRepository.insert(calculos);
    }
}
