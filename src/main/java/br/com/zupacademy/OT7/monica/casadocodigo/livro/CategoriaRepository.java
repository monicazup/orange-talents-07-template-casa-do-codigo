package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import br.com.zupacademy.OT7.monica.casadocodigo.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    Optional<Categoria> findByNome(@NotBlank String nomeCategoria);
}
