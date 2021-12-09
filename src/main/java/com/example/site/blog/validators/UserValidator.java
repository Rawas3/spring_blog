package com.example.site.blog.validators;

import com.example.site.blog.models.User;
import com.example.site.blog.services.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/*
@Component
@RequiredArgsConstructor
public class UserValidator implements Validator {

    private UserService userService;

    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "required");

        if(user.getUsername().length() < 8 || user.getUsername().length() > 32) {
            errors.rejectValue("username", "size.username");
        }

        if(userService.findByUsername(user.getUsername()) !=null) {
            errors.rejectValue("username", "duplicate.username");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");

        if(user.getPassword().length() < 8) {
            errors.rejectValue("password", "size.password");
        }

        if(!user.getConfirmedPassword().equals(user.getPassword())) {
            errors.rejectValue("confirmedPassword", "duplicate.password");
        }
    }

}
*/
