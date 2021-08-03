package br.com.zupacademy.OT7.monica.casadocodigo.categoria;

import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CategoriaRequest {
    @NotNull(message = "não pode ser nulo") @NotBlank(message = "não pode estar em branco")
    @CampoUnico(entityClass = Categoria.class, fieldName = "nome", message = "não pode ser repetido")
    private String nome;

    @Deprecated
    public CategoriaRequest(){}

    public CategoriaRequest(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Categoria toEntity() {
        return new Categoria(nome);
    }
}
