package com.calend.content_calender.repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.calend.content_calender.model.Content;
import com.calend.content_calender.model.Status;

import jakarta.annotation.PostConstruct;

@Repository
public class ContentCollectionRepository {

 private final List<Content> content = new ArrayList<>();
 public ContentCollectionRepository(){

 }

 public List<Content>findAll(){
    return content;
 }
 public Optional<Content> findById(Integer id){
    return content.stream().filter(c -> c.id().equals(id)).findFirst();

 }
 @PostConstruct
 private void init(){
  Content c = new Content(1, "Blogs", "My first blog", Status.IDEA, null, LocalDateTime.now() ,null, "");
  content.add(c);
 }
 public void save(Content cont){
   content.add(cont);
 }
 public boolean existsById(Integer id){
 return content.stream().filter(c -> c.id().equals(id)).count()==1;
}

public void delete(Integer id){
   content.removeIf(c ->c.id().equals(id));

}
}
