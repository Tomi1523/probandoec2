package com.example.otro.OdontologoRepository;


import com.example.otro.Entidades.Turnos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurnosRepository extends JpaRepository<Turnos, Integer> {
}
