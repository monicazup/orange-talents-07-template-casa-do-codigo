package br.com.zupacademy.OT7.monica.casadocodigo.cliente;

import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

    List<Estado> findByPaisId(Long id);
}
