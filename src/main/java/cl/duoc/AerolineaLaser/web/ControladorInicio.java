package cl.duoc.AerolineaLaser.web;

import cl.duoc.AerolineaLaser.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class ControladorInicio {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public String inicio(Model modelo, @AuthenticationPrincipal User user) {
        String url = "";
        String rol = user.getAuthorities().toString();

        if (rol.contains("ADMIN")) {
            url = "/index";
        } else if (rol.contains("USERTURISMO")) {
            url = "/servicioTurismo";
        } else if (rol.contains("USERPREMIUM")) {
            url = "/servicioPremium";
        }

        return url;
    }

    @GetMapping("/servicioTurismo")
    public String turismo(Model modelo){
        return "servicioTurismo";
    }
    
    @GetMapping("/servicioPremium")
    public String premium(Model modelo){
        return "servicioPremium";
    }
    
    @GetMapping("/login")
    public String login(Model modelo) {
        return "login";
    }

    @GetMapping("/logout")
    public String logout(Model modelo) {
        return "logout";
    }
}
