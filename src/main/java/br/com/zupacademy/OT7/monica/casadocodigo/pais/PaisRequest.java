package br.com.zupacademy.OT7.monica.casadocodigo.pais;

import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;
import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Locale;

public class PaisRequest {

    @NotBlank
    @CampoUnico(entityClass = Pais.class, fieldName = "nome")
    private String nome;

    public PaisRequest(String nome) {
        this.nome = nome.toUpperCase();
    }

    @Deprecated PaisRequest(){}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
