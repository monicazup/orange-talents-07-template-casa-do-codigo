package br.com.zupacademy.OT7.monica.casadocodigo.pais;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/paises")
public class PaisController {

    @Autowired
    EntityManager manager;

    @PostMapping @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid PaisRequest request) {

        Pais pais = new Pais(request.getNome());
        manager.persist(pais);

        return ResponseEntity.ok().build();

    }

}
