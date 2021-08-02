package br.com.zupacademy.OT7.monica.casadocodigo.autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
