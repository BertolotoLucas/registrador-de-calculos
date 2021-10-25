package br.com.lucasbertoloto.registradordecalculos.repository;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CalculoRepository extends MongoRepository<Calculo, String> {}
