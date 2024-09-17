package com.mballem.curso.jasper.spring.repository;

import com.mballem.curso.jasper.spring.entity.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query("SELECT DISTINCT e.uf FROM Endereco e ORDER BY e.uf ASC")
    List<String> findUfs();
}
