package com.ons.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.ons.demo.entities.Employe;
import com.ons.demo.entities.Entreprise;
@RepositoryRestResource(path = "rest")
public interface EmployeRepository extends JpaRepository<Employe, Long> {
	
	List<Employe> findByNomEmploye(String nom);
	List<Employe> findByNomEmployeContains(String nom);
	
	


	
	@Query("select e from Employe e where e.entreprise = ?1") 
	List<Employe> findByEntreprise (Entreprise entreprise);
	
	List<Employe> findByEntrepriseIdEntreprise(Long id);
	
	List<Employe> findByOrderByNomEmployeAsc();
	
	@Query("select e from Employe e order by e.nomEmploye ASC, e.salaire DESC")
	List<Employe> trierEmployeesNomsSalaire ();

}
