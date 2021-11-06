package br.com.lucasbertoloto.registradordecalculos.dummydata;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.service.CalculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class CalculoDummyData {
    @Autowired
    CalculoService calculoService;

    //@PostConstruct
    public void populaBanco(){
        List<Calculo> calculos = new ArrayList<>();

        Calculo calculo = new Calculo();
        calculo.setNomePessoa("Bruno");
        calculo.setOperacao("1000 + 2000");
        calculo.setResultado(3000D);
        calculos.add(calculo);

        calculo = new Calculo();
        calculo.setNomePessoa("Bruno2");
        calculo.setOperacao("10 * 20");
        calculo.setResultado(200D);
        calculos.add(calculo);

        calculo = new Calculo();
        calculo.setNomePessoa("Bruno3");
        calculo.setOperacao("50/2");
        calculo.setResultado(25D);
        calculos.add(calculo);

        calculoService.saveAll(calculos);
    }
}
