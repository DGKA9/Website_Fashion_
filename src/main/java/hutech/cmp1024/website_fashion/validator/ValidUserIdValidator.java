package hutech.cmp1024.website_fashion.validator;


import hutech.cmp1024.website_fashion.entity.User;
import hutech.cmp1024.website_fashion.validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext context){
        if(user == null){
            return true;
        }
        return user.getId() != null;
    }
}
