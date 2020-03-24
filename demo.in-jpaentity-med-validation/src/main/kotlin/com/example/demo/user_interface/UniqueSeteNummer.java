
package com.example.demo.user_interface;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Constraint(validatedBy = UniqueSeteNummerConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface UniqueSeteNummer {
    String message() default "Setene må ha unike nummer i en kupe";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}