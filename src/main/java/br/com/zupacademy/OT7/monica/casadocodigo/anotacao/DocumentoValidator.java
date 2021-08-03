package br.com.zupacademy.OT7.monica.casadocodigo.anotacao;

import org.hibernate.validator.internal.constraintvalidators.hv.br.CNPJValidator;
import org.hibernate.validator.internal.constraintvalidators.hv.br.CPFValidator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class DocumentoValidator implements ConstraintValidator<DocumentoOficial, String> {

    private CPFValidator cpfValidator;
    private CNPJValidator cnpjValidator;

    @Override
    public void initialize(DocumentoOficial constraintAnnotation) {
        cpfValidator = new CPFValidator();
        cpfValidator.initialize(null);
        cnpjValidator = new CNPJValidator();
        cnpjValidator.initialize(null);

    }

    @Override
    public boolean isValid(String documento, ConstraintValidatorContext constraintValidatorContext) {
        return cpfValidator.isValid(documento, constraintValidatorContext) || cnpjValidator.isValid(documento, constraintValidatorContext);
    }

}
