package liga.medical.personservice.core.controller;

import liga.medical.personservice.core.service.UserService;
import liga.medical.personservice.core.validation.UserValidator;
import liga.medical.personservice.dto.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    private final UserValidator userValidator;

    private final UserService userService;

    public AuthController(UserValidator userValidator, UserService userService) {
        this.userValidator = userValidator;
        this.userService = userService;
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage() {
        return "successLogin";
    }

    @GetMapping("/register")
    public String userForm(Model model) {
        model.addAttribute("user", new UserDTO());
        return "registration";
    }

    @PostMapping("/register")
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