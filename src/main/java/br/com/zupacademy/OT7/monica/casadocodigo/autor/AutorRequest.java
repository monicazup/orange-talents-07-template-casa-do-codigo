package br.com.zupacademy.OT7.monica.casadocodigo.autor;

import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class AutorRequest {

    @NotBlank
    String nome;
    @NotBlank @Email @CampoUnico(entityClass = Autor.class, fieldName = "email")
    String email;
    @NotBlank @Size(max = 400)
    String descricao;


    public AutorRequest(String nome, String email, String descricao) {
        this.nome = nome;
        this.email = email;
        this.descricao = descricao;
    }

    @Deprecated //Para uso do Spring
    public AutorRequest() {
    }

    public Autor toEntity() {
        return new Autor(this.nome, this.email, this.descricao);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
