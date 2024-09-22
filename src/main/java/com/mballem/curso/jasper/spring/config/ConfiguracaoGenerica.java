package com.mballem.curso.jasper.spring.config;

import jakarta.servlet.Servlet;
import net.sf.jasperreports.j2ee.servlets.ImageServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Configuration
public class ConfiguracaoGenerica {

    @Bean
    public Connection connection(DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }

    @Bean
    public ServletRegistrationBean jasperImageServlet() {
        ServletRegistrationBean servlet = new ServletRegistrationBean(
                (Servlet) new ImageServlet(), "/image/servlet/*"
        );
        servlet.setLoadOnStartup(1);
        return servlet;
    }
}
