package br.com.zupacademy.OT7.monica.casadocodigo.pais;

import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Objects;

@Entity
public class Pais {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @OneToMany(targetEntity = Estado.class, cascade = CascadeType.ALL)
    //@OneToMany(mappedBy = "id")
    //@JoinColumn(nullable = true)
    private List<Estado> estado;

    public Pais(String nome) {
        this.nome = nome.toUpperCase();
    }

    @Deprecated
    public Pais() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pais pais = (Pais) o;
        return Objects.equals(nome, pais.nome);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome);
    }
}
