package br.com.zupacademy.OT7.monica.casadocodigo.anotacao;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = DocumentoValidator.class)
public @interface DocumentoOficial {

    String message() default "Documento inválido.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String fieldName();

    Class<?> entityClass();

}

