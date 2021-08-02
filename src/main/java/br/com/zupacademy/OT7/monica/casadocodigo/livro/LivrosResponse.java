package br.com.zupacademy.OT7.monica.casadocodigo.livro;

public class LivrosResponse {
    Long id;
    String titulo;

    @Deprecated
    LivrosResponse() { }

    public LivrosResponse(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
