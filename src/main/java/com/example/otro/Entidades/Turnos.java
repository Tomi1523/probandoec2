package com.example.otro.Entidades;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TURNOS")
public class Turnos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "paciente_id", nullable = false,referencedColumnName = "id")

    @JsonIgnoreProperties(value ={"TURNOS", "hibernateLazyInitializer"})
    private Paciente paciente;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "odontologo_id", nullable = false,referencedColumnName = "id")
    @JsonIgnoreProperties(value ={"TURNOS", "hibernateLazyInitializer"})
    private Odontologo odontologo;
    private LocalDate fecha;

}
