package com.ArcomTech.ApiV1.controller;

import com.ArcomTech.ApiV1.service.EntityService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

//@CrossOrigin
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class AbstractController<ID, C, D> {
    private EntityService<ID, C, D> entityService;

    //@CrossOrigin
    @GetMapping
    public ResponseEntity<List<D>> getAll(){
        System.out.println("#### abstract GetAll");
        return ResponseEntity.ok(entityService.getAll());
    }


    //@CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<D> get(@PathVariable ID id){
        System.out.println("#### abstract Get => " + id);
        return ResponseEntity.ok(entityService.get(id));
    }

    //@CrossOrigin
    @PostMapping
    public ResponseEntity<D> add(@Valid @RequestBody C creationDto){
        System.out.println("#### abstract ADD => " + creationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(entityService.create(creationDto));
    }

    //@CrossOrigin
    @PutMapping("/{id}")
    public HttpStatus update(@Valid @RequestBody C creationDto, @PathVariable ID id){
        System.out.println("#### abstract Put => " + id + " --- " + creationDto);
        entityService.update(id, creationDto);
        return HttpStatus.OK;
    }

    //@CrossOrigin
    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable ID id){
        System.out.println("#### abstract Delete => " + id);
        entityService.delete(id);
        return HttpStatus.OK;
    }
}
