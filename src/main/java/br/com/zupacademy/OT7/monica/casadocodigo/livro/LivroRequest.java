package br.com.zupacademy.OT7.monica.casadocodigo.livro;


import br.com.zupacademy.OT7.monica.casadocodigo.Autor.Autor;
import br.com.zupacademy.OT7.monica.casadocodigo.Autor.AutorRepository;
import br.com.zupacademy.OT7.monica.casadocodigo.anotacao.CampoUnico;
import br.com.zupacademy.OT7.monica.casadocodigo.categoria.Categoria;
import br.com.zupacademy.OT7.monica.casadocodigo.config.ApiException;
import org.springframework.http.HttpStatus;

import javax.persistence.EntityManager;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Optional;

public class LivroRequest {
    @NotBlank
    @CampoUnico(fieldName = "titulo", entityClass = Livro.class)
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    private String sumario;
    @NotBlank
    @CampoUnico(fieldName = "isbn", entityClass = Livro.class)
    private String isbn;
    @NotBlank
    private String nomeCategoria;
    @NotNull
    private Long nomeAutor;
    @NotNull
    @Min(100)
    private Integer numeroDePaginas;
    @NotNull
    @Min(20)
    private BigDecimal preco;
    @Future
    private LocalDate dataDePublicacao;

    @Deprecated
    public LivroRequest() {

    }

    public LivroRequest(String titulo,
                        String resumo,
                        String sumario,
                        String isbn,
                        String nomeCategoria,
                        Long nomeAutor,
                        Integer numeroDePaginas,
                        BigDecimal preco,
                        LocalDate dataDePublicacao) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.nomeCategoria = nomeCategoria;
        this.nomeAutor = nomeAutor;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
        this.dataDePublicacao = dataDePublicacao;
    }

    public LivroRequest(String titulo,
                        String resumo,
                        String isbn,
                        String nomeCategoria,
                        Long nomeAutor,
                        Integer numeroDePaginas,
                        BigDecimal preco) {
        this.titulo = titulo;
        this.resumo = resumo;
        this.isbn = isbn;
        this.nomeCategoria = nomeCategoria;
        this.nomeAutor = nomeAutor;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
    }

    public Livro toEntity(AutorRepository autorRepository, CategoriaRepository categoriaRepository) {


        Categoria categoria = categoriaRepository.findByNome(this.nomeCategoria).get();
//        if (categoria == null) throw new ApiException(HttpStatus.NOT_FOUND, "Categoria não encontrada.");
//
//        if (autorRepository.existsById(nomeAutor)) throw new ApiException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        Autor autor = autorRepository.findById(nomeAutor).get();



        return new Livro(titulo, resumo, sumario, isbn,
                categoria, autor, numeroDePaginas, preco,
                dataDePublicacao);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public void setSumario(String sumario) {
        this.sumario = sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getNomeCategoria() {
        return nomeCategoria;
    }

    public void setNomeCategoria(String nomeCategoria) {
        this.nomeCategoria = nomeCategoria;
    }

    public Long getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(Long nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }

    public void setDataDePublicacao(LocalDate dataDePublicacao) {
        this.dataDePublicacao = dataDePublicacao;
    }
}
