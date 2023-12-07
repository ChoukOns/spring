package com.ons.demo.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Employe {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEmploye;
	
	@NotNull
	@Size (min = 4,max = 15)
	private String nomEmploye;
	
	
	
	@Min(value = 10)
	@Max(value = 10000)
	private Double salaire;
	
	/* @OneToOne private Image image; */
	 
	
	
	  @OneToMany (mappedBy = "employe") 
	  private List<Image> images;
	 
	
		/* private String imagePath; */
	
	
	
	@ManyToOne
	private Entreprise entreprise;
	
	public Employe() {
		super();
		}
	
		public Employe(String nomEmploye, Double salaire) {
		super();
		this.nomEmploye = nomEmploye;
		this.salaire = salaire;

	
		}
	


	public Long getIdEmploye() {
		return idEmploye;
		}
	public void setIdEmploye(Long idEmploye) {
		this.idEmploye = idEmploye;
		}
		
		
		public String getNomEmploye() {
		return nomEmploye;
		}
		public void setNomEmploye(String nomEmploye) {
			this.nomEmploye = nomEmploye;
			}
		

		
			
		public Double getSalaire() {
		return salaire;
		}
		public void setSalaire(Double salaire) {
		this.salaire = salaire;
		}

		
		public Entreprise getEntreprise() {
			return entreprise;
		}

		public void setEntreprise(Entreprise entreprise) {
			this.entreprise = entreprise;
		}
		
		/*
		 * public Image getImage() { return image; }
		 * 
		 * public void setImage(Image image) { this.image = image; }
		 */

		@Override
		public String toString() {
			return "Employe [idEmploye=" + idEmploye + ", nomEmploye=" + nomEmploye + ", salaire=" + salaire
					+ ", image=" + images + ", entreprise=" + entreprise + "]";
		}
		 
		
		  public List<Image> getImages() { return images; } 
		  public void  setImages(List<Image> images) { this.images = images; }
		  
			/*
			 * public String getImagePath() { return imagePath; } public void
			 * setImagePath(String imagePath) { this.imagePath = imagePath; }
			 */
		 

	
}
