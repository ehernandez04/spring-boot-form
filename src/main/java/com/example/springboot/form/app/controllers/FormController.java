package com.example.springboot.form.app.controllers;

import com.example.springboot.form.app.models.domain.Usuario;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model){
        Usuario usuario = new Usuario();

        model.addAttribute("titulo", "Formulario usuarios");
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/form")
    public String procesar(@Valid Usuario usuario,  BindingResult result, Model model/*,
                           @RequestParam(name = "username") String username,
                           @RequestParam String password,
                           @RequestParam String email*/){
        /*
        Usuario usuario = new Usuario();
        usuario.setUsername(username);
        usuario.setPassword(password);
        usuario.setEmail(email);


        model.addAttribute("titulo", "Resultado form");
        model.addAttribute("username", username);
        model.addAttribute("password", password);
        model.addAttribute("email", email);
        */

        model.addAttribute("titulo", "Resultado form");

        if(result.hasErrors()){
            /*Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->{
                errores.put(err.getField(),"El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });

            model.addAttribute("error", errores);*/

            return "form";
        }

        model.addAttribute("usuario", usuario);
        return "resultado";
    }
}
