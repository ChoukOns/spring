package com.ons.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ons.demo.entities.Employe;
import com.ons.demo.services.EmployeService;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class EmployeRESTController {
	
	@Autowired
	EmployeService employeService;
	
	
	@RequestMapping(method =RequestMethod.GET)
	public List<Employe> getAllEmployes() {
	return employeService.getAllEmployes();
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Employe getEmployeById(@PathVariable("id") Long id) 
	{ return employeService.getEmploye(id);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public Employe createEmploye(@RequestBody Employe employe) {
	return employeService.saveEmploye(employe);
	}
	
	
	@RequestMapping(method = RequestMethod.PUT)
	public Employe updateEmploye(@RequestBody Employe employe) {
	return employeService.updateEmploye(employe);
	}
	
	@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
	public void deleteEmploye(@PathVariable("id") Long id)
	{
	employeService.deleteEmployeById(id);
	}
	
	/*
	 * @RequestMapping(value="/empsentreprise/{idEntreprise}",method =
	 * RequestMethod.GET) public List<Employe>
	 * getEmployesByEntrepriseId(@PathVariable("idEntreprise") Long idEntreprise) {
	 * return employeService.findByEntrepriseIdEntreprise(idEntreprise); }
	 */
	@RequestMapping(value="/empsentreprie/{idEntreprise}",method = RequestMethod.GET)
	public List<Employe> getEmployeByEntrepriseId(@PathVariable("idEntreprise") Long idEntreprise) {
	return employeService.findByEntrepriseIdEntreprise(idEntreprise);
	}
	
	
	@RequestMapping(value="/EmployeByName/{nom}",method = RequestMethod.GET)
	public List<Employe> findByNomEmployeContains(@PathVariable("nomEmploye") String nom) {
	return employeService.findByNomEmployeContains(nom);
	}

}
