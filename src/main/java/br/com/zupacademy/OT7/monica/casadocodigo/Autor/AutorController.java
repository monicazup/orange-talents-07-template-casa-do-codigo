package br.com.zupacademy.OT7.monica.casadocodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

//    @PersistenceContext
//    private EntityManager manager;

    @Autowired
    private AutorRepository repository;

    @PostMapping
    //@Transactional
    public void cadastrar(@RequestBody @Valid AutorRequest request) {

        repository.save(request.toEntity());
        //entityManager.persist(request.toEntity());
    }
}
