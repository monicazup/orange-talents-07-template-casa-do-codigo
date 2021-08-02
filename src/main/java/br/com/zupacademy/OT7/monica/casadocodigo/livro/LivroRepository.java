package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    @Override
    Page<Livro> findAll(Pageable pageable);
}
