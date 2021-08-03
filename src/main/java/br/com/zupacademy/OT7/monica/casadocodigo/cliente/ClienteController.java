package br.com.zupacademy.OT7.monica.casadocodigo.cliente;

import br.com.zupacademy.OT7.monica.casadocodigo.estado.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    EntityManager manager;

    @Autowired
    EstadoRepository estadoRepository;

    @PostMapping @Transactional
    public ResponseEntity<?> cadastrar(@RequestBody ClienteRequest request) {

        Cliente cliente = request.toEntity(manager, estadoRepository);
        manager.persist(cliente);
        return ResponseEntity.ok().build();
    }
}
