package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import br.com.zupacademy.OT7.monica.casadocodigo.autor.Autor;
import br.com.zupacademy.OT7.monica.casadocodigo.categoria.Categoria;

import java.math.BigDecimal;
import java.time.LocalDate;

public class DetalheSiteLivroResponse {

    Long id;
    private String titulo;
    private String resumo;
    private String sumario;
    private String isbn;
    private String categoria;
    private String autor;
    private Integer numeroDePaginas;
    private BigDecimal preco;
    private LocalDate dataDePublicacao;

    public DetalheSiteLivroResponse(Livro livro) {
        this.id = livro.id;
        this.titulo = livro.getTitulo();
        this.resumo = livro.getResumo();
        this.sumario = livro.getSumario();
        this.isbn = livro.getIsbn();
        this.categoria = livro.getCategoria().getNome();
        this.autor = livro.getAutor().getNome();
        this.numeroDePaginas = livro.getNumeroDePaginas();
        this.preco = livro.getPreco();
        this.dataDePublicacao = livro.getDataDePublicacao();
    }

//    public DetalheSiteLivroResponse(Livro livro) {
//        this.
//    }

    @Deprecated
    public DetalheSiteLivroResponse() {
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public String getSumario() {
        return sumario;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getAutor() {
        return autor;
    }

    public Integer getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public LocalDate getDataDePublicacao() {
        return dataDePublicacao;
    }
}