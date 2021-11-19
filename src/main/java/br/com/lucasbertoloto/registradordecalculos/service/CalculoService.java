package br.com.lucasbertoloto.registradordecalculos.service;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.repository.CalculoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CalculoService {
    @Autowired
    CalculoRepository calculoRepository;

    @Transactional
    public Calculo save(Calculo calculo) {
        return calculoRepository.save(calculo);
    }

    @Transactional
    public List<Calculo> saveAll(List<Calculo> calculos) {
        return calculoRepository.saveAll(calculos);
    }

    @Transactional
    public List<Calculo> findAll() {
        return calculoRepository.findAll();
    }

    @Transactional
    public List<Calculo> insertList(List<Calculo> calculos) {
        return calculoRepository.insert(calculos);
    }

    @Transactional
    public Long count() {
        return calculoRepository.count();
    }

    @Transactional
    public Page<Calculo> findByNomePessoaContainingIgnoreCase(String name, Pageable page) {
        return calculoRepository.findByNomePessoaContainingIgnoreCase(name, page);
    }

    @Transactional
    public Page<Calculo> findAll(Pageable page) {
        return calculoRepository.findAll(page);
    }
}
