package com.seannavery.dojosandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.seannavery.dojosandninjas.models.Dojo;
import com.seannavery.dojosandninjas.models.Ninja;
import com.seannavery.dojosandninjas.services.DojoService;

@Controller
public class DojoController {
	private final DojoService dojoService;
    public DojoController(DojoService dojoService){
        this.dojoService = dojoService;
    }
    
    @RequestMapping("/dojos")
    public String index(Model model, @ModelAttribute("dojo") Dojo dojo) {
    	List<Dojo> dojos = dojoService.allDojos();
    	model.addAttribute("dojos", dojos);
    	return "index.jsp";
    }
    
    @RequestMapping("/dojos/{dojo_id}")
    public String showDojo(@PathVariable Long dojo_id, Model model) {
        Dojo someAwesomeDojo = dojoService.findDojo(dojo_id);
        model.addAttribute("dojo", someAwesomeDojo);
        return "showdojo.jsp";
    }
    
    @RequestMapping("/dojos/new")
    public String showDojo(@ModelAttribute("dojo") Dojo dojo) {   
        return "newdojoform.jsp";
    }
    
    @RequestMapping("/ninjas/new")
    public String showNewNinjaForm(@ModelAttribute("ninja") Ninja ninja, Model model) { 
    	List<Dojo> dojos = dojoService.allDojos();
    	model.addAttribute("dojos", dojos);
        return "newninjaform.jsp";
    }
    
    @RequestMapping(value="/dojos/create", method=RequestMethod.POST)
    public String createDojo(Model model, @Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
        	List<Dojo> dojos = dojoService.allDojos();
        	model.addAttribute("dojos", dojos);
            return "index.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos";
        }
    }
    
    @RequestMapping("/dojos/{dojo_id}/edit")
    public String edit(@PathVariable("dojo_id") Long dojo_id, Model model) {
        Dojo dojo = dojoService.findDojo(dojo_id);
        model.addAttribute("dojo", dojo);
        return "edit.jsp";
    }
    
    @RequestMapping(value="/dojoss/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            dojoService.updateDojo(dojo);
            return "redirect:/dojos";
        }
    } 
    
    @RequestMapping(value = "/dojos/{dojo_id}", method = RequestMethod.DELETE)
	public String destroy(@PathVariable("dojo_id") Long dojo_id) {
		dojoService.deleteDojo(dojo_id);
		return "redirect:/dojos";
	}
    
}
