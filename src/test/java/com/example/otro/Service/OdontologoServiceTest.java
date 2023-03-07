package com.example.otro.Service;

import com.example.otro.Entidades.Odontologo;
import com.example.otro.OdontologoRepository.OdontologoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class OdontologoServiceTest {

    @Mock
    private OdontologoRepository odontologoRepository;

    @InjectMocks
    private OdontologoService odontologoService;

    private Odontologo odontologo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        odontologo = new Odontologo();
        odontologo.setApellido("dopazo");
        odontologo.setNombre("tomi");
        odontologo.setId(1);
        odontologo.setMatricula(12);

    }

    @Test
    void listar() {
        when(odontologoRepository.findAll()).thenReturn(Arrays.asList(odontologo));
        assertNotNull(odontologoService.listar());
    }
}