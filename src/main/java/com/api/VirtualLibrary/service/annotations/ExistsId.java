package com.api.VirtualLibrary.service.annotations;

import com.api.VirtualLibrary.service.validator.ExistsIdValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Target({ElementType.FIELD})
@Constraint(validatedBy = {ExistsIdValidator.class})
@Retention(RetentionPolicy.RUNTIME)

public @interface ExistsId {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    Class<?> className();

}
