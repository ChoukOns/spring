package com.ons.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import com.ons.demo.entities.Employe;
import com.ons.demo.entities.Entreprise;
import com.ons.demo.repos.EmployeRepository;
import com.ons.demo.repos.EntrepriseRepository;
import com.ons.demo.repos.ImageRepository;

@Service
public class EmployeServiceImpl implements EmployeService{
	
	@Autowired 
	EmployeRepository employeRepository;
	
	@Autowired
	EntrepriseRepository entrepriseRepository;
	
	ImageRepository imageRepository;
	

	  @Override
	  public Employe saveEmploye(Employe e) {
		  return  employeRepository.save(e);
		  }
	
			
			/*
			 * @Override public Employe updateEmploye(Employe e) { return
			 * employeRepository.save(e); }
			 */
	  
	  
	  @Override
	  public Employe updateEmploye(Employe e) {
	 // Long oldEmpImageId = this.getEmploye(e.getIdEmploye()).getImage().getIdImage();
	  //Long newEmpImageId = e.getImage().getIdImage();
	 Employe empUpdated = employeRepository.save(e);
	  //if (oldEmpImageId != newEmpImageId) //si l'image a été modifiée
	 // imageRepository.deleteById(oldEmpImageId);
	  return empUpdated;
	  }
			
	  
	@Override
	public void deleteEmploye(Employe e) 
	{ employeRepository.delete(e);
	}
	
	@Override
	public void deleteEmployeById(Long id) {
	employeRepository.deleteById(id);
	}
	
	@Override
	public Employe getEmploye(Long id) 
	{ return employeRepository.findById(id).get();
	}
	
	@Override
	public List<Employe> getAllEmployes() 
	{ return employeRepository.findAll();
	}
	
	@Override
	public Page<Employe> getAllEmployeesParPage(int page, int size) {
		return employeRepository.findAll(PageRequest.of(page, size));
	}
	
	@Override
	public List<Employe> findByNomEmploye(String nom) {
	return employeRepository.findByNomEmploye(nom);
	}
	
	@Override public List<Employe> findByNomEmployeContains(String nom) {
		return employeRepository.findByNomEmployeContains(nom);
		}
	
	
	@Override
	public List<Employe> findByEntreprise(Entreprise entreprise) {
	return employeRepository.findByEntreprise(entreprise);
	}

	@Override
	public List<Employe> findByEntrepriseIdEntreprise(Long id) {
		return employeRepository.findByEntrepriseIdEntreprise(id);
	}

	@Override
	public List<Employe> findByOrderByNomEmployeAsc() {
		return employeRepository.findByOrderByNomEmployeAsc();
	}

	@Override
	public List<Employe> trierEmployeesNomsSalaire() {
		return employeRepository.trierEmployeesNomsSalaire();
	}
	
	@Override
	public List<Entreprise> getAllEntreprises() {
		
		return entrepriseRepository.findAll();
	}




	
}
