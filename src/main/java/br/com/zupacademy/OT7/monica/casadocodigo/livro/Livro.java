package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import br.com.zupacademy.OT7.monica.casadocodigo.autor.Autor;
import br.com.zupacademy.OT7.monica.casadocodigo.categoria.Categoria;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String titulo;
    @NotBlank
    @Size(max = 500)
    private String resumo;
    @Lob
    @Basic(fetch = FetchType.LAZY) //a anotação @Basic(fetch=LAZY) serve que
    // esse campo seja lido do banco somente quando o método getDescription() for chamado.
    // Isso evita leitura desnecessária de grandes quantidades de dados.
    private String sumario;
    @NotBlank
    private String isbn;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Categoria categoria;
    @NotNull
    @ManyToOne(cascade = CascadeType.MERGE)
    private Autor autor;
    @NotNull
    @Min(100)
    private Integer numeroDePaginas;
    private BigDecimal preco;
    @Future
    private LocalDate dataDePublicacao;

    @Deprecated
    public Livro() {
    }

    public Livro(String titulo,
                 String resumo,
                 String sumario,
                 String isbn,
                 Categoria categoria,
                 Autor autor,
                 Integer numeroDePaginas,
                 BigDecimal preco,
                 LocalDate dataDePublicacao) {

        this.titulo = titulo;
        this.resumo = resumo;
        this.sumario = sumario;
        this.isbn = isbn;
        this.categoria = categoria;
        this.autor = autor;
        this.numeroDePaginas = numeroDePaginas;
        this.preco = preco;
        this.dataDePublicacao = dataDePublicacao;
    }

    public LivrosResponse toResponse() {
        return new LivrosResponse(this.id, this.titulo);
    }

    public static List<LivrosResponse> toListaResponse(List<Livro> livros) {
        List<LivrosResponse> listaDto = new ArrayList<>();
        for (Livro livro : livros) {
            listaDto.add(livro.toResponse());
        }
        return listaDto;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public Autor getAutor() {
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
