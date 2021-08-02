package br.com.zupacademy.OT7.monica.casadocodigo.autor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.Instant;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank @Email
    private String email;
    @NotBlank @Size(max = 400)
    private String descricao;
    @NotNull
    private Instant instant = Instant.now();

    public Autor(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }


    @Deprecated //Para uso do Spring
    public Autor() {
    }

    public String getNome() {
        return this.nome;
    }
}
