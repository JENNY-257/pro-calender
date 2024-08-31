package com.calend.content_calender.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calend.content_calender.model.Content;
import com.calend.content_calender.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
public class ContenController {

   private final ContentCollectionRepository repository;
   public  ContenController(ContentCollectionRepository repository){
    this.repository = repository;
   }

//    make a request and find all content in the system
  @GetMapping("")
  public List<Content> findAll(){
    return repository.findAll();
  }
}
