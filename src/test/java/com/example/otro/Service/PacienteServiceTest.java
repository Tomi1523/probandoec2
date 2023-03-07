package com.example.otro.Service;


import com.example.otro.Entidades.Paciente;
import com.example.otro.OdontologoRepository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
class PacienteServiceTest {
    @Mock
    private PacienteRepository pacienteRepository;

    @InjectMocks
    private PacienteService pacienteService ;

    private Paciente paciente;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        paciente = new Paciente();
        paciente.setNombre("tomi");
        paciente.setApellido("dopazo");
        paciente.setId(1);
        paciente.setDomicilio("calle falsa 123");
        paciente.setFechaDeAlta(LocalDate.ofEpochDay(0));

    }

    @Test
    void listar() {
        when(pacienteRepository.findAll()).thenReturn(Arrays.asList(paciente));
        assertNotNull(pacienteService.listar());
    }
}
