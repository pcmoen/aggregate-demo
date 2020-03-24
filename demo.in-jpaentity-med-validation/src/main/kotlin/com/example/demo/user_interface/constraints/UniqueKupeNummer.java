
package com.example.demo.user_interface.constraints;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = UniqueKupeNummerConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueKupeNummer {
    String message() default "Kupene må ha unike nummer i en vogn";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}