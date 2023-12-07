package com.ons.demo.restcontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

import com.ons.demo.entities.Image;
import com.ons.demo.services.ImageService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.PUT, RequestMethod.GET, RequestMethod.DELETE}, allowedHeaders = "*")
public class ImageRestController {
	
	@Autowired
	ImageService imageService ;
	
	
	  @RequestMapping(value = "/upload" , method = RequestMethod.POST) public Image
	  uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
	  return imageService.uplaodImage(file); }
	 
	

	
	
	@RequestMapping(value = "/get/info/{id}" , method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
	return imageService.getImageDetails(id) ;
	}
	
	
	@RequestMapping(value = "/load/{id}" , method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException 
	{ return imageService.getImage(id);
	}
	
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id){
	imageService.deleteImage(id);
	}
	
	
	@RequestMapping(value="/update",method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image")MultipartFile file) throws IOException {
	return imageService.uplaodImage(file);
	}
	
	  @PostMapping(value = "/uplaodImageEmp/{idEmploye}" )
	  public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
	  @PathVariable("idEmploye") Long idEmploye)throws IOException 
	  { return imageService.uplaodImageEmp(file,idEmploye); }
	  
	  @RequestMapping(value = "/getImagesEmp/{idEmploye}" ,method =RequestMethod.GET) 
	  public List<Image> getImagesEmp(@PathVariable("idEmploye")Long idEmploye) throws IOException { return
	  imageService.getImagesParEmp(idEmploye); }
	 
}
