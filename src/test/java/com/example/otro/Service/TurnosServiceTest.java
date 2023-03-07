package com.example.otro.Service;

import com.example.otro.Entidades.Odontologo;
import com.example.otro.Entidades.Paciente;
import com.example.otro.Entidades.Turnos;
import com.example.otro.OdontologoRepository.TurnosRepository;
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
class TurnosServiceTest {
    @Mock
    private TurnosRepository turnosRepository;

    @InjectMocks
    private TurnosService turnosService;

    private Turnos turnos;

    private Paciente paciente;
    private Odontologo odontologo;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        turnos = new Turnos();
        turnos.setFecha(LocalDate.ofEpochDay(12-12));
        turnos.setId(1);
        turnos.setOdontologo(odontologo);
        turnos.setPaciente(paciente);


    }

    @Test
    void listar() {
        when(turnosRepository.findAll()).thenReturn(Arrays.asList(turnos));
        assertNotNull(turnosService.listar());
    }
}
