package com.mballem.curso.jasper.spring.controller;

import com.mballem.curso.jasper.spring.entity.Funcionario;
import com.mballem.curso.jasper.spring.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Connection;
import java.time.format.DateTimeFormatter;

@Controller
public class HomeController {

    @Autowired
    private Connection connection;

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/conn")
    public String myConn(Model model) {
        model.addAttribute(
                "conn",
                connection != null ? "Conexão ok!!!" : "Ops... sem conexão"
        );
        return "index";
    }

    @GetMapping("/certificados")
    public String validadorCertificado(@RequestParam("cid") Long cid, Model model) {
        Funcionario funcionario = funcionarioRepository.findById(cid).orElseThrow();
        model.addAttribute(
                "mensagem",
                "Confirmamos a veracidade desse certificado, pertencente a " +
                        funcionario.getNome() + ", emitido em " +
                        funcionario.getDataDemissao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))
        );
        return "index";
    }

}
