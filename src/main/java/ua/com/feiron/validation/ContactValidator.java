package ua.com.feiron.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import ua.com.feiron.domain.Contact;

@Component
public class ContactValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Contact.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "required.phone", "Phone is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required.email", "email is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fio", "required.fio", "fio is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "note", "required.note", "note is required");

    }
}
