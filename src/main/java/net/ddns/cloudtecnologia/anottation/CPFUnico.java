package net.ddns.cloudtecnologia.anottation;


import net.ddns.cloudtecnologia.anottation.impl.CPFUnicoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CPFUnicoImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CPFUnico {
    String message() default "Já existe uma Pessoa com o CPF informado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
