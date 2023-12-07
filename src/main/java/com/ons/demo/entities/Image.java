package com.ons.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Image {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idImage ;
	private String name ;
	private String type ;
	@Column( name = "IMAGE" , length = 4048576 )
	@Lob
	private byte[] image;
	/* @OneToOne private Employe employe; */
	 

	
	  @ManyToOne
	  
	  @JoinColumn 
	  (name="EMPLOYEE_ID")
	  
	  @JsonIgnore 
	  private Employe employe;
	 
}
