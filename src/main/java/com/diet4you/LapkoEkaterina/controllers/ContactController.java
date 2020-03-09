package com.diet4you.LapkoEkaterina.controllers;

import com.diet4you.LapkoEkaterina.Contact;
import com.diet4you.LapkoEkaterina.MailComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller

public class ContactController {
    @Autowired
    MailComponent mailComponent;
    @GetMapping("/")
    public String contact(@ModelAttribute Contact contact) {
        return "contact";
    }
    @PostMapping("/")
    public String processContact(@Validated Contact contact, RedirectAttributes model, BindingResult bindingResult) {

        if (bindingResult.hasErrors())
            return "contact";

        if (mailComponent.sendSimpleMail(contact)) {
            model.addFlashAttribute("classCss", "alert sukcesu");
            model.addFlashAttribute("message", "Twoja wiadomość została wysłana");
        } else {
            model.addFlashAttribute("classCss", "alert ostrzeżenie");
            model.addFlashAttribute("message", "Wystąpił nieoczekiwany błąd, powtórz później");
        }

        return "redirect:/";
    }


}

