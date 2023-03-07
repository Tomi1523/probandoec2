package com.example.otro.Service;



import com.example.otro.Entidades.Paciente;
import com.example.otro.Exception.ResourceNotFoundException;
import com.example.otro.OdontologoRepository.PacienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@AllArgsConstructor
@Service
public class PacienteService {

    private final PacienteRepository pacienteRepository;


    public void agregar(Paciente P){
        pacienteRepository.save(P);
    }



    public Paciente buscar(Integer id) throws ResourceNotFoundException {
        return  pacienteRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException());
    }

    public void delete(Integer id){
        pacienteRepository.deleteById(id);
    }

    public void update(Paciente P)  {
        pacienteRepository.save(P);
    }

    public List<Paciente> listar(){
        return pacienteRepository.findAll();
    }
}
