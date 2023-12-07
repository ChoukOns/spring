package com.ons.demo.controllers;

import java.text.ParseException;

import java.util.List;

import jakarta.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ons.demo.entities.Employe;
import com.ons.demo.entities.Entreprise;
import com.ons.demo.services.EmployeService;


@Controller
public class EmployeController {
	
	@Autowired
	EmployeService employeService;
	
	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap)
	{
		List<Entreprise> entrs = employeService.getAllEntreprises();
		Entreprise entr = new Entreprise();
	modelMap.addAttribute("entreprises", entrs);
	modelMap.addAttribute("employe", new Employe());
	modelMap.addAttribute("mode", "new");
	modelMap.addAttribute("page",0);
	return "formEmploye";
	}
	
	@RequestMapping("/saveEmploye")
	public String saveEmploye(@Valid Employe employe,BindingResult bindingResult,
	   @ModelAttribute("page") int pageFromPrevious,
	    @RequestParam (name="size", defaultValue = "2") int size,
	    RedirectAttributes redirectAttributes,ModelMap modelMap)
	{
		
		int page;
	if (bindingResult.hasErrors())
		return "formEmploye";
		
	
    if (employe.getIdEmploye()==null) //adding
        page = employeService.getAllEmployes().size()/size; // calculer le nbr de pages
    else //updating
        page = pageFromPrevious;
   
    employeService.saveEmploye(employe);
    redirectAttributes.addAttribute("page", page);
    return "redirect:/ListeEmployees";
		}

    


	@RequestMapping("/ListeEmployees")
	public String listeEmployees(ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
			@RequestParam (name="size", defaultValue = "3") int size)
	{
		Page<Employe> emp = employeService.getAllEmployeesParPage(page, size);
		modelMap.addAttribute("employees", emp);
		 modelMap.addAttribute("pages", new int[emp.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEmployees";

	}
	@RequestMapping("/supprimerEmploye")
	public String supprimerEmploye(@RequestParam("id") Long id,
	 ModelMap modelMap,@RequestParam (name="page",defaultValue = "0") int page,
	 @RequestParam (name="size", defaultValue = "2") int size)
	{ 
	employeService.deleteEmployeById(id);
	Page<Employe> emp = employeService.getAllEmployeesParPage(page, size);
			modelMap.addAttribute("employees", emp);
			modelMap.addAttribute("pages", new int[emp.getTotalPages()]);
			modelMap.addAttribute("currentPage", page);
			modelMap.addAttribute("size", size);

	return "listeEmployees";
	}
	
	@RequestMapping("/updateEmploye")
	public String updateEmploye(@ModelAttribute("employe") Employe employe,
	@RequestParam("date") String date,ModelMap modelMap) throws ParseException 
	{
		 
		 employeService.updateEmploye(employe);
		 List<Employe> emps = employeService.getAllEmployes();
		 modelMap.addAttribute("employees", emps);
		return "listeEmployees";
		}
	
	@RequestMapping("/modifierEmploye")
	public String upadteEmploye(@RequestParam("id") Long id,@RequestParam("page") int page,ModelMap modelMap)
	{
	Employe emp= employeService.getEmploye(id);
	List<Entreprise> entr = employeService.getAllEntreprises();
	modelMap.addAttribute("employe", emp);
	modelMap.addAttribute("mode", "edit");
	modelMap.addAttribute("page",page);
	modelMap.addAttribute("entreprises", entr);
	return "formEmploye";
	}



}
