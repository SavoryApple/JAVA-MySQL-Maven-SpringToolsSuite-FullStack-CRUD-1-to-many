package com.seannavery.dojosandninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seannavery.dojosandninjas.models.Ninja;
import com.seannavery.dojosandninjas.services.NinjaService;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
    public NinjaController(NinjaService ninjaService){
        this.ninjaService = ninjaService;
    }
    
    @RequestMapping(value="/ninjas/create", method=RequestMethod.POST)
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
        	System.out.println(result);
            return "redirect:/ninjas/new";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/dojos";
        }
    }
}