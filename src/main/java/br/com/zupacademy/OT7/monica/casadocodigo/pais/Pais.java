package br.com.zupacademy.OT7.monica.casadocodigo.pais;

import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @OneToMany(mappedBy = "id")
    private List<Estado> estado;
//
//    public Pais(String nome, Estado estado) {
//        this.nome = nome;
//        this.estado = estado;
//    }

    public Pais(String nome) {
        this.nome = nome.toUpperCase();
    }

    @Deprecated public Pais() {}
}
