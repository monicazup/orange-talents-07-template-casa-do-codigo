package br.com.zupacademy.OT7.monica.casadocodigo.categoria;

import br.com.zupacademy.OT7.monica.casadocodigo.categoria.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Optional;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {


    boolean existsByNome(String nome);

    Categoria findByNome(String nome);
}
