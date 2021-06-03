package com.example.testproject.controller

import com.example.testproject.model.Project
import com.example.testproject.service.ProjectService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("api/project")
class ProjectController(val projectService: ProjectService) {

    @GetMapping
    fun getProject(@RequestParam(defaultValue = "id") sortBy: String, @RequestParam(defaultValue = "asc") sortType: String): MutableList<Project> {
        return projectService.getProject(sortBy, sortType)
    }

    @GetMapping("/{projectId}")
    fun getProjectById(@PathVariable projectId: String): Project {
        return projectService.getProjectById(projectId)
    }

    @DeleteMapping
    fun deleteProject(@RequestParam projectId: String) {
        projectService.deleteProject(projectId)
    }

    @PostMapping
    fun registerNewProject(@RequestBody project: Project): Project {
        return projectService.addNewProject(project)
    }

    @PutMapping
    fun updateProject(@RequestBody project: Project): Project {
        return projectService.updateProject(project)
    }
}