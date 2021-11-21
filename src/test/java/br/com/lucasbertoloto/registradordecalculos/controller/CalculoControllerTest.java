package br.com.lucasbertoloto.registradordecalculos.controller;

import br.com.lucasbertoloto.registradordecalculos.model.Calculo;
import br.com.lucasbertoloto.registradordecalculos.repository.CalculoRepository;
import br.com.lucasbertoloto.registradordecalculos.service.CalculoService;
import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;

@ExtendWith(MockitoExtension.class)
public class CalculoControllerTest {
    private CalculoController victim;

    @Mock
    private CalculoService calculoService;

    @Mock
    private CalculoRepository calculoRepository;

    @BeforeEach
    public void setupEach(){
        victim = new CalculoController();
    }

    @Test
    public void shouldReturnSuccess_WhenList() {}
}
