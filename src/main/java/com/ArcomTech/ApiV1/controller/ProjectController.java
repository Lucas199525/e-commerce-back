package com.ArcomTech.ApiV1.controller;


import com.ArcomTech.ApiV1.model.Project;
import com.ArcomTech.ApiV1.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.NoSuchElementException;

@RestController
public class ProjectController {

    private ProjectService projectService;

    @GetMapping("project/{id}")
    public ResponseEntity<Project> get(@PathVariable Integer id){
        try {
            Project project = projectService.get(id);
            return new ResponseEntity<Project>(project, HttpStatus.OK);
        }catch(NoSuchElementException e){
            return  new ResponseEntity<Project>(HttpStatus.NOT_FOUND);
        }
    }
}
