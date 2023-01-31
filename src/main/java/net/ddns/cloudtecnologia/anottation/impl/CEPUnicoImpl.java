package net.ddns.cloudtecnologia.anottation.impl;

import net.ddns.cloudtecnologia.anottation.CEPUnico;
import net.ddns.cloudtecnologia.service.impl.EnderecoServiceImpl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CEPUnicoImpl implements ConstraintValidator<CEPUnico, String> {

    @Inject
    private EnderecoServiceImpl service;

    @Override
    public boolean isValid(String cep, ConstraintValidatorContext constraintValidatorContext) {

        return service.findByCep(cep).list().isEmpty();
    }
}
