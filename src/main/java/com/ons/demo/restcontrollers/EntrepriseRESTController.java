package com.ons.demo.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ons.demo.entities.Entreprise;
import com.ons.demo.repos.EntrepriseRepository;



@RestController
@RequestMapping("/api/entr")
@CrossOrigin("*")
public class EntrepriseRESTController {
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	@RequestMapping(method=RequestMethod.GET)
	public List<Entreprise> getAllEntreprises()
	{
	return entrepriseRepository.findAll();
	}
	@RequestMapping(value="/{id}",method = RequestMethod.GET)
	public Entreprise getEntrepriseById(@PathVariable("id") Long id) {
		return entrepriseRepository.findById(id).get();
	}
	
	

}
