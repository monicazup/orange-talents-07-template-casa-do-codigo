package br.com.zupacademy.OT7.monica.casadocodigo.cliente;

import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;
import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.DocumentoOficial;
import br.com.zupacademy.OT7.monica.casadocodigo.config.ApiException;
import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;
import br.com.zupacademy.OT7.monica.casadocodigo.pais.Pais;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

public class ClienteRequest {

    @NotBlank
    @Email
    @CampoUnico(entityClass = Cliente.class, fieldName = "email")
    private String email;
    @NotBlank
    private String nome;
    @NotBlank
    private String sobrenome;
    @DocumentoOficial(entityClass = Cliente.class, fieldName = "documento")
    @CampoUnico(entityClass = Cliente.class, fieldName = "documento")
    private String documento;
    @NotBlank
    private String endereco;
    @NotBlank
    private String complemento;
    @NotBlank
    private String cidade;
    @NotNull
    private Long pais;
    private Long estado;
    @NotBlank
    private String telefone;
    @NotBlank
    private String cep;

    public ClienteRequest(String email,
                          String nome,
                          String sobrenome,
                          String documento,
                          String endereco,
                          String complemento,
                          String cidade,
                          Long pais,
                          Long estado,
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

    public Cliente toEntity(EntityManager entityManager, EstadoRepository estadoRepository) {

        Pais possivelPais = entityManager.find(Pais.class, this.pais);
        if (possivelPais == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "O campo não pode ser nulo");
        }

        List<Estado> estados = estadoRepository.findByPaisId(this.pais);
        if (!estados.isEmpty() && estado == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "O campo não pode ser nulo");
        }

        if (this.estado == null) {
            return new Cliente(email, nome, sobrenome, documento, endereco,
                    complemento, cidade, possivelPais, telefone, cep);
        }

        Estado possivelEstado = entityManager.find(Estado.class, this.estado);
        if (possivelEstado == null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "O campo não pode ser nulo");
        }
        if (possivelEstado.pertenceAo(possivelPais)) {
            return new Cliente(email, nome, sobrenome, documento, endereco,
                    complemento, cidade, possivelPais, possivelEstado, telefone, cep);
        }
        throw new ApiException(HttpStatus.BAD_REQUEST, "O campo não pode ser nulo");

    }

    /*
    CONSTRUTOR DEFAULT,
    GETTERS E SETTERS
     */
    @Deprecated
    public ClienteRequest() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
