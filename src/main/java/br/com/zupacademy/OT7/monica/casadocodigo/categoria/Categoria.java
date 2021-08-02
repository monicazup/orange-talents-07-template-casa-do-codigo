package br.com.zupacademy.OT7.monica.casadocodigo.categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Categoria {

    @Id @GeneratedValue
    Long id;
    @NotBlank
    @Column(unique = true)
    String nome;

    @Deprecated
    public Categoria() {}

    public Categoria(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
