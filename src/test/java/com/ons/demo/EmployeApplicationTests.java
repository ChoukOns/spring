package com.ons.demo;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;

import com.ons.demo.entities.Employe;
import com.ons.demo.entities.Entreprise;
import com.ons.demo.repos.EmployeRepository;
import com.ons.demo.services.EmployeService;


@SpringBootTest
class EmployeesApplicationTests {

	@Autowired
	private EmployeRepository employeRepository;
	@Autowired
	private EmployeService employeService;
	@Test
	public void testCreateEmploye() {
		Employe emp = new Employe("foulan", 500.50);/* ,new Date() */
	employeRepository.save(emp);
	}
	
	@Test
	public void testFindEmploye()
	{ Employe e = employeRepository.findById(1L).get(); System.out.println(e);
	}
	
	@Test
	public void testUpdateEmploye()
	{ Employe e = employeRepository.findById(1L).get();
	e.setSalaire(1000.0); employeRepository.save(e);
	}
	
	@Test
	public void testDeleteEmploye()
	{ employeRepository.deleteById(1L);
	}
	
	@Test
	public void testListerTousEmployes()
	{
	List<Employe> emp = employeRepository.findAll();
	for (Employe e : emp)
	{
	System.out.println(e);
	}
	}
	



	@Test
	public void testFindByNomEmployeContains()
	{
	Page<Employe> emp = employeService.getAllEmployeesParPage(0,2);
	System.out.println(emp.getSize());
	System.out.println(emp.getTotalElements());
	System.out.println(emp.getTotalPages());
	emp.getContent().forEach(e -> {System.out.println(e.toString());
	 });
	
	}
	
	@Test
	public void testFindEmployeByNom()
	{ List<Employe> emps = employeRepository.findByNomEmploye("Ons"); 
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testFindEmployeByNomContains()
	{ List<Employe> emps = employeRepository.findByNomEmployeContains("F"); 
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	
	
	@Test
	public void testfindByEntreprise()
	{
	Entreprise entr = new Entreprise();
	entr.setIdEntreprise(1L);
	List<Employe> emps = employeRepository.findByEntreprise(entr);
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void findByEntrepriseIdEntreprise()
	{
	List<Employe> emps = employeRepository.findByEntrepriseIdEntreprise(1L);
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test
	public void testfindByOrderByNomEmployeAsc()
	{
	List<Employe> emps = employeRepository.findByOrderByNomEmployeAsc();
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}
	
	@Test public void testTrierEmployeesNomsSalaire()
	{
	List<Employe> emps = employeRepository.trierEmployeesNomsSalaire();
	for (Employe e : emps)
	{
	System.out.println(e);
	}
	}

}
