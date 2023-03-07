package com.example.otro.Controllers;


import com.example.otro.Entidades.Paciente;
import com.example.otro.Exception.ResourceNotFoundException;
import com.example.otro.Service.PacienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:3000")
@AllArgsConstructor
@RestController
public class PacienteControllers {
    private final PacienteService ps;



    @GetMapping("/Paciente/{id}")
    public Optional<Paciente> buscarPaciente(@PathVariable Integer id) throws ResourceNotFoundException {
        return Optional.ofNullable(ps.buscar(id));
    }

    @GetMapping("/ListPacientes")
        public List<Paciente> listPacientes()  {
                    return ps.listar();
                }



    @PostMapping("/AgregarPaciente")
    public ResponseEntity<?> AgregarPaciente(@RequestBody Paciente paciente)  {
        ps.agregar(paciente);
        return ResponseEntity.ok("Se agrego al paciente correctamente");
    }



    @PutMapping ("/ActulizarPaciente/{id}")
    public ResponseEntity<?> actualizarPaciente(@RequestBody Paciente paciente) {
        ps.update(paciente);
        return ResponseEntity.ok("Se actulizo al paciente correctamente");
    }

    @DeleteMapping("/EliminarPaciente/{id}")
    public ResponseEntity<?> deletePaciente(@PathVariable Integer id) throws ResourceNotFoundException {
        if(ps.buscar(id) == null){
            throw new  ResourceNotFoundException();
        } else{
            ps.delete(id);
            return  ResponseEntity.ok("se elimino  correctamente el paciente con id " + id );
        }}





}
