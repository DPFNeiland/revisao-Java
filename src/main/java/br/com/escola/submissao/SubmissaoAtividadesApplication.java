package br.com.escola.submissao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe principal da aplicação Spring Boot.
 *
 * Esta classe inicializa o contexto Spring e torna a API disponível em http://localhost:8080.
 */
@SpringBootApplication
public class SubmissaoAtividadesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SubmissaoAtividadesApplication.class, args);
    }
}
