package liga.medical.personservice.core.validation;

import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.dto.UserDTO;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

    private final UserService userService;

    public UserValidator(UserService userService) {
        this.userService = userService;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UserDTO.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        UserDTO user = (UserDTO) o;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "NotEmpty");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");

        if (user.getPassword().length() < 8 || user.getPassword().length() > 32)
            errors.rejectValue("password", "Size.userForm.password");
        if (userService.findByUsername(user.getUsername()) != null)
            errors.rejectValue("username", "Dublicate.userform.username");
    }
}
