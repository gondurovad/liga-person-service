package liga.medical.personservice.core.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.core.validation.UserValidator;
import liga.medical.personservice.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Api(value = "API для работы с авторизацией пользователей")
public class AuthController {

    private final UserValidator userValidator;

    private final UserService userService;

    public AuthController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/login")
    @ApiOperation(value = "Получение страницы логина")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    @ApiOperation(value = "Получение страницы при успешной авторизации")
    public String getSuccessPage() {
        return "successLogin";
    }

    @GetMapping("/register")
    @ApiOperation(value = "Получение формы регистрации пользователей")
    public String userForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/register")
    @ApiOperation(value = "Регистрация пользователей")
    public String userSubmit(@ModelAttribute UserDTO dto, BindingResult bindingResult) {
        userValidator.validate(dto, bindingResult);
        if (bindingResult.hasErrors()) {
            return "errorRegistration";
        }
        System.out.println(dto);
        userService.saveUser(dto);
        return "login";
    }
}