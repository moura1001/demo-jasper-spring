package com.mballem.curso.jasper.spring.repository;

import com.mballem.curso.jasper.spring.entity.Nivel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NivelRepository extends JpaRepository<Nivel, Long> {

    @Query("SELECT n.nivel FROM Nivel n ORDER BY n.id ASC")
    List<String> findNiveis();
}
