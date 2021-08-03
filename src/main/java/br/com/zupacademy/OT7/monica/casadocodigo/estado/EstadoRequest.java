package br.com.zupacademy.OT7.monica.casadocodigo.estado;

import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class EstadoRequest {

    @NotBlank @CampoUnico(entityClass = Estado.class, fieldName = "nome")
    String nome;
    @NotNull
    Long idPais;

    public EstadoRequest(String nome, Long idPais) {
        this.nome = nome;
        this.idPais = idPais;
    }

    @Deprecated
    public EstadoRequest(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getIdPais() {
        return idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }
}
