package net.ddns.cloudtecnologia.anottation;


import net.ddns.cloudtecnologia.anottation.impl.EMAILUnicoImpl;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = EMAILUnicoImpl.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface EMAILUnico {
    String message() default "Já existe uma Pessoa com o EMAIL informado!";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
