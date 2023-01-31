package net.ddns.cloudtecnologia.anottation;


import net.ddns.cloudtecnologia.anottation.impl.CEPUnicoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = CEPUnicoImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CEPUnico {
    String message() default "Já existe um endereço com o CEP informado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
