package com.ons.demo.services;

import java.util.List;

import org.springframework.data.domain.Page;


import com.ons.demo.entities.Employe;
import com.ons.demo.entities.Entreprise;


public interface EmployeService {
	Employe saveEmploye(Employe e);
	Employe updateEmploye(Employe e);
	void deleteEmploye(Employe e);
	void deleteEmployeById(Long id);
	Employe getEmploye(Long id);
	List<Employe> getAllEmployes();
	List<Entreprise> getAllEntreprises();
	Page<Employe> getAllEmployeesParPage(int page, int size);
	
	List<Employe> findByNomEmploye(String nom);
	List<Employe> findByNomEmployeContains(String nom);
	
	List<Employe> findByEntreprise (Entreprise entreprise);
	List<Employe> findByEntrepriseIdEntreprise(Long id);
	List<Employe> findByOrderByNomEmployeAsc();
	List<Employe> trierEmployeesNomsSalaire();
	

}
