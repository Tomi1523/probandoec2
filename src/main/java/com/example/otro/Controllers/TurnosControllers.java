package com.example.otro.Controllers;



import com.example.otro.Entidades.Turnos;
import com.example.otro.Service.TurnosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RestController
public class TurnosControllers {
    private final TurnosService ts;

    @GetMapping("/Turnos/{id}")
    public  Optional<Turnos> buscarTurnos(@PathVariable Integer id) {
          return  ts.buscar(id);
    }

    @GetMapping("/ListTurnos")
    public  List<Turnos> listTurnos()  {
        return ts.listar();
    }

    @PostMapping("/AgregarTurnos")
    public  Turnos AgregarTurnos(@RequestBody Turnos turnos)  {
        ts.agregar(turnos);
        return turnos;
    }

    @PutMapping("/ActulizarTurno")
    public void actualizarTurnos(@RequestBody Turnos turnos) {
        ts.update(turnos);
    }


    @DeleteMapping("/EliminarTurnos/{id}")
    public void deletePaciente(@PathVariable Integer id) {
        ts.delete(id);
    }


}
