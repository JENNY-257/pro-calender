package com.calend.content_calender.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.calend.content_calender.model.Content;
import com.calend.content_calender.repository.ContentCollectionRepository;

@RestController
@RequestMapping("/api/content")
@CrossOrigin
public class ContenController {

   private final ContentCollectionRepository repository;
   public  ContenController(ContentCollectionRepository repository){
    this.repository = repository;
   }

//make a request and find all content in the system
  @GetMapping("")
  public List<Content> findAll(){
    return repository.findAll();
  }

  @GetMapping("/{id}")
  public Content findById(@PathVariable Integer id){
    return repository.findById(id)
    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found"));
  }


  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("")
  public void create(@RequestBody Content cont){
    repository.save(cont);
  }
  
  @ResponseStatus(HttpStatus.NO_CONTENT)
  @PutMapping("/{id}")
  public void update(@RequestBody Content cont , @PathVariable Integer id){

    if(!repository.existsById(id)){
      throw new ResponseStatusException(HttpStatus.NOT_FOUND,"content not found");
    }
    repository.save(cont);

  }
  

  @ResponseStatus(HttpStatus.NO_CONTENT)
  @DeleteMapping("/{id}")
  public void delete(@PathVariable Integer id){
    repository.delete(id);
  }
}
