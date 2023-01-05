package br.com.crud.web.myApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class home_controller {

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("message", "Bem-vindo à minha primeira application!");
        return "home";
    }
    @GetMapping("/cadastropessoa")
    public String inicio() {
      return "cadastro/cadastropessoa";
    }

}
