package com.example.otro.Service;


import com.example.otro.Entidades.Turnos;
import com.example.otro.OdontologoRepository.TurnosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class TurnosService {
    private final TurnosRepository turnosRepository;

    private final PacienteService ps;
    private final OdontologoService os;



    public void agregar(Turnos T){
        if(T.getOdontologo() != null && T.getPaciente() != null){
            ps.agregar(T.getPaciente());
            os.agregar(T.getOdontologo());}
        this.turnosRepository.save(T);
    }

    public Optional<Turnos> buscar(Integer id){
        return  turnosRepository.findById(id);
    }

    public void delete(Integer id){
        turnosRepository.deleteById(id);
    }

    public void update(Turnos T)  {
        turnosRepository.save(T);
    }

    public List<Turnos> listar(){
        return turnosRepository.findAll();
    }
}
