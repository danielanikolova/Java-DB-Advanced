package game.store.validators;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class EmailValidator implements ConstraintValidator<Email, String>{


    @Override
    public void initialize(Email email) {

    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext constraintValidatorContext) {

        return email.contains("@") && email.contains(".");
    }
}
