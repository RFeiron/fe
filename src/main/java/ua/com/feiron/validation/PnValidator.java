package ua.com.feiron.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.feiron.domain.Pn;

@Component
public class PnValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Pn.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "required.name", "Name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "work_b", "required.work_b", "Rabochaya Shirina is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "base_b", "required.base_b", "Obshaya Shirina is required");
    }
}
