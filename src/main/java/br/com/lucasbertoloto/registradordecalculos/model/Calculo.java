package br.com.lucasbertoloto.registradordecalculos.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Document("calculos")
public class Calculo {
    @Id
    private String id;
    @NotBlank
    private String nomePessoa;
    @NotBlank
    private String operacao;
    private Double resultado;

    public Calculo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getOperacao() {
        return operacao;
    }

    public void setOperacao(String operacao) {
        this.operacao = operacao;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }

    //(Example of operation: 1,plus,3)
    public Double calc(){
        Double x1;
        Double x2;
        Double result = null;
        String[] split = getOperacao().split(",");
        x1 = Double.parseDouble(split[0]);
        String operation = split[1];
        x2 = Double.parseDouble(split[2]);
        switch (operation){
            case "plus": {
                result = x1+x2;
                break;
            }
            case "minus": {
                result = x1-x2;
                break;
            }
            case "multiply":{
                result = x1*x2;
                break;
            }
            case "divide":{
                if (x2!=0){
                    result = x1/x2;
                }
                break;
            }
            default: {
                break;
            }
        }
        this.setResultado(result);
        return result;
    }

    @Override
    public String toString() {
        return "Calculo{" +
                "id='" + id + '\'' +
                ", nomePessoa='" + nomePessoa + '\'' +
                ", operacao='" + operacao + '\'' +
                ", resultado=" + resultado +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Calculo calculo = (Calculo) o;
        return Objects.equals(id, calculo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
