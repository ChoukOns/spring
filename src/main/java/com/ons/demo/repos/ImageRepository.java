package com.ons.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ons.demo.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long>{

}
