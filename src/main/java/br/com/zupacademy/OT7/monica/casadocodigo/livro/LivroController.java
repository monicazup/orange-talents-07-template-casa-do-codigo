package br.com.zupacademy.OT7.monica.casadocodigo.livro;

import br.com.zupacademy.OT7.monica.casadocodigo.autor.AutorRepository;
import br.com.zupacademy.OT7.monica.casadocodigo.categoria.CategoriaRepository;
import br.com.zupacademy.OT7.monica.casadocodigo.config.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    LivroRepository livroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @PostMapping @Transactional @CacheEvict(value = "listaDeLivros", allEntries = true)
    public ResponseEntity<?> cadastrar(@RequestBody @Valid LivroRequest request) {

//        if (categoria == null) throw new ApiException(HttpStatus.NOT_FOUND, "Categoria não encontrada.");
        if (!categoriaRepository.existsByNome(request.getNomeCategoria())) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Categoria não encontrada");
        }
        if (!autorRepository.existsById(request.getIdAutor())) {
            throw new ApiException(HttpStatus.NOT_FOUND, "Autor não encontrado");
        }

        Livro livro = request.toEntity(autorRepository, categoriaRepository);

        entityManager.persist(livro);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/listar")
    @Cacheable(value = "listaDeLivros")
    public ResponseEntity<List<LivrosResponse>> listar(@RequestParam Integer pagina, @RequestParam Integer qnt) {
        Pageable paginaRequest = PageRequest.of(pagina, qnt);
        List<Livro> livros = livroRepository.findAll(paginaRequest).toList();

        return ResponseEntity.ok().body(Livro.toListaResponse(livros));
    }
}
