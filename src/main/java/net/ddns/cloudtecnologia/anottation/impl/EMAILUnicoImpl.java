package net.ddns.cloudtecnologia.anottation.impl;


import net.ddns.cloudtecnologia.anottation.EMAILUnico;
import net.ddns.cloudtecnologia.service.impl.PessoaServiceImpl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EMAILUnicoImpl implements ConstraintValidator<EMAILUnico, String> {

    @Inject
    private PessoaServiceImpl service;

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {
        return service.findByEmail(email).list().isEmpty();
    }
}
