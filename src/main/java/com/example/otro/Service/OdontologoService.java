package com.example.otro.Service;


import com.example.otro.Entidades.Odontologo;
import com.example.otro.Exception.ResourceNotFoundException;
import com.example.otro.OdontologoRepository.OdontologoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class OdontologoService {


    private final OdontologoRepository repository;


    public void agregar(Odontologo O){
            repository.save(O);
        }

    public Odontologo buscar(Integer id) throws ResourceNotFoundException {

        return  repository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
    }

    public void delete(Integer id){
        repository.deleteById(id);
    }

    public void update(Odontologo O)  {
           repository.save(O);
    }

    public List<Odontologo> listar(){
       return repository.findAll();
    }





}
