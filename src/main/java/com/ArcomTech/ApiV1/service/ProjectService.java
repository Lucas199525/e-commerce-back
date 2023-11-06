package com.ArcomTech.ApiV1.service;


import com.ArcomTech.ApiV1.model.Project;
import com.ArcomTech.ApiV1.repository.ProjectRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> listAll(){return projectRepository.findAll();}

    public Project get(Integer id){ return projectRepository.findById(id).get();}

    public void  save(Project project){projectRepository.save(project);}

    public void delete(Integer id){projectRepository.deleteById(id);}
}
