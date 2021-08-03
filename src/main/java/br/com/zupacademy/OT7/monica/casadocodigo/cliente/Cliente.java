package br.com.zupacademy.OT7.monica.casadocodigo.cliente;

import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;
import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;
import br.com.zupacademy.OT7.monica.casadocodigo.pais.Pais;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Cliente {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    //@Documento
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    @ManyToOne
    private Pais pais;
    @ManyToOne
    private Estado estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public Cliente(String email,
                   String nome,
                   String sobrenome,
                   String documento,
                   String endereco,
                   String complemento,
                   String cidade,
                   Pais pais,
                   Estado estado,
                   String telefone,
                   String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.estado = estado;
        this.telefone = telefone;
        this.cep = cep;
    }

    public Cliente(String email,
                   String nome,
                   String sobrenome,
                   String documento,
                   String endereco,
                   String complemento,
                   String cidade,
                   Pais pais,
                   String telefone,
                   String cep) {
        this.email = email;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.documento = documento;
        this.endereco = endereco;
        this.complemento = complemento;
        this.cidade = cidade;
        this.pais = pais;
        this.telefone = telefone;
        this.cep = cep;
    }

    @Deprecated
    public Cliente() {
    }

}
