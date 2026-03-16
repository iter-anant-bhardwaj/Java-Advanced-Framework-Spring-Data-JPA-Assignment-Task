package com.capgemini.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.entity.Project;
import com.capgemini.repository.ProjectRepository;

@Service
public class ProjectService {
	@Autowired
    private ProjectRepository projectRepository;

    public void save(Project project) {
        projectRepository.save(project);
        System.out.println("Project Saved Successfully!");
    }

    public List<Project> getProjects(){
        return projectRepository.findAll();
    }

    public Project getProject(Integer id) {
        Optional<Project> optional = projectRepository.findById(id);
        return optional.orElse(null);
    }

    public void deleteProject(Integer id) {
        projectRepository.deleteById(id);
        System.out.println("Project Deleted Successfully!");
    }
}
