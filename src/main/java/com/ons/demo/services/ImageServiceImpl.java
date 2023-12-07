package com.ons.demo.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ons.demo.entities.Employe;
import com.ons.demo.entities.Image;
import com.ons.demo.repos.EmployeRepository;
import com.ons.demo.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService{
	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	EmployeService employeService;
	
	@Autowired
	EmployeRepository employeRepository;
	
	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		 /*Ce code commenté est équivalent au code utilisant le design pattern Builder
		 * Image image = new Image(null, file.getOriginalFilename(), 
		 file.getContentType(), file.getBytes(), null);
		 return imageRepository.save(image);*/
		
		return imageRepository.save(Image.builder()
				.name(file.getOriginalFilename())
				.type(file.getContentType())
				.image(file.getBytes()).build() );
	}
	
	@Override
	public Image getImageDetails(Long id) throws IOException{ final Optional<Image> dbImage = imageRepository. findById (id);
	return Image.builder()
	.idImage(dbImage.get().getIdImage())
	.name(dbImage.get().getName())
	.type(dbImage.get().getType())
	.image(dbImage.get().getImage()).build() ;
	}
	
	
	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException{ 
		final Optional<Image> dbImage = imageRepository. findById (id);
	return ResponseEntity
	.ok()
	.contentType(MediaType.valueOf(dbImage.get().getType()))
	.body(dbImage.get().getImage());
	}
	@Override
	public void deleteImage(Long id) {
	imageRepository.deleteById(id);
	}
	
	
	  @Override public Image uplaodImageEmp(MultipartFile file,Long idEmploye)
	  throws IOException { Employe e = new Employe(); e.setIdEmploye(idEmploye);
	  return imageRepository.save(Image.builder() .name(file.getOriginalFilename())
	  .type(file.getContentType()) .image(file.getBytes()) .employe(e).build() ); }
	 
	
	
	
	  @Override public List<Image> getImagesParEmp(Long empId) { Employe e =
	  employeRepository.findById(empId).get(); return e.getImages(); }
	 
	
}
	



