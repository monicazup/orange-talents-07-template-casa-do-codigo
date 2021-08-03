package br.com.zupacademy.OT7.monica.casadocodigo.estado;

import br.com.zupacademy.OT7.monica.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank private String nome;

    @ManyToOne
    @NotNull
    private Pais pais;

    public Estado(String nome, Pais pais) {
        this.nome = nome;
        this.pais = pais;
    }

    @Deprecated
    public Estado(){}


    public boolean pertenceAo(Pais possivelPais) {

        return this.pais.equals(possivelPais);

    }
}
