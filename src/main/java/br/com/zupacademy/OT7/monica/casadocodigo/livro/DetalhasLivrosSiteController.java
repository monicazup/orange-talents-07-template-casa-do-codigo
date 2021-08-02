package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;

@RestController
public class DetalhasLivrosSiteController {

    @Autowired
    EntityManager manager;

    @GetMapping("/livro/{id}") @Transactional(readOnly = true)
    public ResponseEntity<?> detalharLivroResponse(@PathVariable("id") Long id) {

        Livro livro = manager.find(Livro.class, id);
       // Livro livro = findBy()
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        DetalheSiteLivroResponse response = new DetalheSiteLivroResponse(livro);
        return ResponseEntity.ok().body(response);

    }
}
