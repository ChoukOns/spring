package com.ons.demo.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "nomEmp", types = { Employe.class })
public interface EmployeProjection {
	public String getNomEmploye();

}
