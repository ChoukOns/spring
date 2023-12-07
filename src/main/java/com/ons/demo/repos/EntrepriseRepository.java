package com.ons.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.ons.demo.entities.Entreprise;

@RepositoryRestResource(path = "entr")
@CrossOrigin("http://localhost:4200/") //pour autoriser angular
public interface EntrepriseRepository extends JpaRepository<Entreprise, Long> {

}
