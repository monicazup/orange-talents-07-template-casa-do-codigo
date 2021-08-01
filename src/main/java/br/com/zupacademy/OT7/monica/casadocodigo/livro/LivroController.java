package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import br.com.zupacademy.OT7.monica.casadocodigo.Autor.AutorRepository;
import br.com.zupacademy.OT7.monica.casadocodigo.config.ApiException;
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

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @PostMapping @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequest request) {

//        if (categoria == null) throw new ApiException(HttpStatus.NOT_FOUND, "Categoria não encontrada.");
        if (!autorRepository.existsById(request.getNomeAutor())) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        }

        Livro livro = request.toEntity(autorRepository, categoriaRepository);

        entityManager.persist(livro);
        return ResponseEntity.ok().build();
    }
}
