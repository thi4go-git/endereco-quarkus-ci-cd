package net.ddns.cloudtecnologia.anottation.impl;


import net.ddns.cloudtecnologia.anottation.CPFUnico;
import net.ddns.cloudtecnologia.service.impl.PessoaServiceImpl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFUnicoImpl implements ConstraintValidator<CPFUnico, String> {

    @Inject
    private PessoaServiceImpl service;

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext constraintValidatorContext) {
        return service.findByCpf(cpf).list().isEmpty();
    }
}
