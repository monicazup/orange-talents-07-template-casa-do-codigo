package br.com.zupacademy.OT7.monica.casadocodigo.autor;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByEmail(String email);

    Autor findByNome(String nomeAutor);
}
