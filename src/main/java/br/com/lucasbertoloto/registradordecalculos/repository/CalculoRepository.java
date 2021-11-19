package br.com.lucasbertoloto.registradordecalculos.repository;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoRepository extends MongoRepository<Calculo, String> {
    Page<Calculo> findByNomePessoaContainingIgnoreCase(String name, Pageable page);
    Page<Calculo> findAll(Pageable page);
}
