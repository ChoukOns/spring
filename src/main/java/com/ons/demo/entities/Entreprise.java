package com.ons.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
public class Entreprise {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEntreprise;
	private String nomEntreprise;
	private String adresseEntreprise;
	
	
	
	@OneToMany(mappedBy = "entreprise")
	@JsonIgnore
	private List<Employe> employees;


	public Entreprise() {
		super();
		
	}



	public Entreprise(Long idEntreprise, String nomEntreprise, String adresseEntreprise, List<Employe> employees) {
		super();
		this.idEntreprise = idEntreprise;
		this.nomEntreprise = nomEntreprise;
		this.adresseEntreprise = adresseEntreprise;
		this.employees = employees;
	}



	public Long getIdEntreprise() {
		return idEntreprise;
	}



	public void setIdEntreprise(Long idEntreprise) {
		this.idEntreprise = idEntreprise;
	}



	public String getNomEntreprise() {
		return nomEntreprise;
	}



	public void setNomEntreprise(String nomEntreprise) {
		this.nomEntreprise = nomEntreprise;
	}



	public String getAdresseEntreprise() {
		return adresseEntreprise;
	}



	public void setAdresseEntreprise(String adresseEntreprise) {
		this.adresseEntreprise = adresseEntreprise;
	}
	
	
	
	
	
	
	
	
	


}
