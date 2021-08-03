package br.com.zupacademy.OT7.monica.casadocodigo.estado;

import br.com.zupacademy.OT7.monica.casadocodigo.config.ApiException;
import br.com.zupacademy.OT7.monica.casadocodigo.pais.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController @RequestMapping("/estados")
public class EstadoController {
    @Autowired
    EntityManager manager;

    @PostMapping
    @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid EstadoRequest request) {

        Pais pais = manager.find(Pais.class, request.getIdPais());

        if (pais== null) {
            throw new ApiException(HttpStatus.BAD_REQUEST, "País não encontrado");
        }

        Estado estado = new Estado(request.getNome(), pais);
        manager.persist(estado);

        return ResponseEntity.ok().build();

    }
}
