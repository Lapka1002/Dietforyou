package com.diet4you.LapkoEkaterina.controllers;

import com.diet4you.LapkoEkaterina.DietaRepository;

import org.jvnet.staxex.BinaryText;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.stream.Stream;


@Controller
public class DietaController {

    @Autowired
    private DietaRepository dietaRepository;

    @RequestMapping(value = "/dieta", method = RequestMethod.GET)
    public String servicesList(Model model) {
        model.addAttribute("diety", dietaRepository.findAll());
        return "dieta";
    }
}
