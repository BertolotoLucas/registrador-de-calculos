package br.com.lucasbertoloto.registradordecalculos.repository;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CalculoRepository extends MongoRepository<Calculo, String> {
    List<Calculo> findByNomePessoaContainingIgnoreCase(String name);
}
