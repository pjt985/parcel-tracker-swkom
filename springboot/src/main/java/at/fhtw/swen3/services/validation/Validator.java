package at.fhtw.swen3.services.validation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import java.util.Set;

@Component
@Slf4j
public class Validator {
    static ValidatorFactory getValidatorFactory() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        return factory;
    }

    public javax.validation.Validator getValidator() {
        return getValidatorFactory().getValidator();
    }

    public <T> void validate(T o) {
        javax.validation.Validator validator = getValidator();
        Set<ConstraintViolation<T>> violations = validator.validate(o);
        violations.forEach(violation -> log.error(violation.getMessage()));
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(violations);
        }
    }
}
