package game.store.validators;

import game.store.models.bindingModel.user.RegisterUser;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

@Component
public class PasswordMatchingValidator implements ConstraintValidator<PasswordMatching, Object> {


    @Override
    public void initialize(PasswordMatching passwordMatching) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if (o instanceof RegisterUser) {
            RegisterUser user = (RegisterUser) o;

            return user.getPassword().equals(user.getConfirmPassword());
        }


        return false;
    }
}
