package com.api.VirtualLibrary.service.validator;

import com.api.VirtualLibrary.service.annotations.ExistsId;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.util.Assert;

import java.util.List;

public class ExistsIdValidator implements ConstraintValidator<ExistsId, Object> {
    @PersistenceContext
    private EntityManager manager;

    private Class<?> className;

    @Override
    public void initialize(ExistsId constraintAnnotation) {
        className = constraintAnnotation.className();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        List<?> list = manager
                .createQuery("select id from " + className.getName() + " where id =:value")
                .setParameter("value", value)
                .getResultList();
        if (value == null || list.size() > 0) {
            return true;
        }
        return false;
    }
}
