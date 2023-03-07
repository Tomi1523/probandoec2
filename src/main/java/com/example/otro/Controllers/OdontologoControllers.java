package com.example.otro.Controllers;


import com.example.otro.Entidades.Odontologo;
import com.example.otro.Exception.ResourceNotFoundException;
import com.example.otro.Service.OdontologoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@CrossOrigin("http://localhost:3000")
@RestController //recibe las peticiones http
@AllArgsConstructor
public class OdontologoControllers {


    private final OdontologoService os;

    @GetMapping("/Odontologo/{id}")
    public Optional<Odontologo> buscarOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {

        return Optional.ofNullable(os.buscar(id));
    }

    @GetMapping("/ListOdontologos")
    public List<Odontologo> listarOdontologos() {
        return os.listar();
    }

    @PostMapping("/AgregarOdontologos")
    public ResponseEntity<?> agregarOdontologo(@RequestBody Odontologo odontologo)  {
        os.agregar(odontologo);
        return ResponseEntity.ok("Se agrego al odontologo correctamente");
    }

    @DeleteMapping("/EliminarOdontologo/{id}")
    public ResponseEntity<?> deleteOdontologo(@PathVariable Integer id) throws ResourceNotFoundException {
        if(os.buscar(id) == null){
           throw new  ResourceNotFoundException();
        } else{
        os.delete(id);
        return  ResponseEntity.ok("se elimino  correctamente el odontologo con id " + id );
    }}

    @PutMapping("/actulizarOdontologo/{id}")
    public ResponseEntity<?> actualizarOdontologo(@RequestBody Odontologo odontologo) {
        os.update(odontologo);
        return ResponseEntity.ok("Se actulizo al odontologo correctamente");
    }
























}
