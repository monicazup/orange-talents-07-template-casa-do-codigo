package br.com.zupacademy.OT7.monica.casadocodigo.anotacao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

public class CampoUnicoValidator implements ConstraintValidator<CampoUnico, String> {

    private String campo;
    private Class<?> entidade;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void initialize(CampoUnico campoUnicoDados) {
        campo = campoUnicoDados.fieldName();
        entidade = campoUnicoDados.entityClass();
    }

    @Override
    public boolean isValid(String valor, ConstraintValidatorContext constraintValidatorContext) {

        Query query = entityManager.createQuery("SELECT 1 FROM " + entidade.getName() + " WHERE " + campo + " = :valor");
        query.setParameter("valor", valor);
        List<?> resultado = query.getResultList();
        if (resultado.size() > 0)
            return false;
        return true;
    }

}
