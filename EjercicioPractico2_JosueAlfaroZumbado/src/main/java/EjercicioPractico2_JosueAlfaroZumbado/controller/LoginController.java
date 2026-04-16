package EjercicioPractico2_JosueAlfaroZumbado.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/error_403")
    public String accesoDenegado() {
        return "error_403";
    }
}