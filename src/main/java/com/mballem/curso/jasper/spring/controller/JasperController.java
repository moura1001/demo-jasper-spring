package com.mballem.curso.jasper.spring.controller;

import com.mballem.curso.jasper.spring.service.JasperService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Controller
public class JasperController {

    @Autowired
    private JasperService service;

    @GetMapping("/reports")
    public String paginaRelatorios() {
        return "relatorios";
    }

    @GetMapping("/relatorio/pdf/jr1")
    public void exibirRelatorio01(@RequestParam("code") String code,
                                  @RequestParam("acao") String acao,
                                  HttpServletResponse response) throws IOException {
        byte[] bytes = service.exportarPdf(code);
        response.setContentType(MediaType.APPLICATION_PDF_VALUE);
        if ("v".equals(acao)) {
            response.setHeader("Content-disposition", "inline; filename=relatorio-"+code+".pdf");
        } else {
            response.setHeader("Content-disposition", "attachment; filename=relatorio-"+code+".pdf");
        }
        response.getOutputStream().write(bytes);
    }
}
