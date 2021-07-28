package br.com.zupacademy.OT7.monica.casadocodigo.Autor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    private AutorRepository repository;

    @PostMapping
    //@Transactional
    public void cadastrar(@RequestBody @Valid AutorRequest request) {

        repository.save(request.toEntity());
        //entityManager.persist(request.toEntity());
    }
}
