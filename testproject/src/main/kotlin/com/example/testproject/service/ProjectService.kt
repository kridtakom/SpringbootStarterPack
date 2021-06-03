package com.example.testproject.service

import com.example.testproject.model.Project
import com.example.testproject.repository.ProjectRepository
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service


@Service
class ProjectService(val projectRepository: ProjectRepository) {

    fun getProject(sortBy: String, sortType: String): MutableList<Project> {
        return if (sortType == "des") {
            getProjectDesc(sortBy)
        } else {
            getProjectASC(sortBy)
        }
    }

    private fun getProjectASC(sortBy: String): MutableList<Project> {
        return projectRepository.findAll(Sort.by(sortBy).ascending())
    }

    private fun getProjectDesc(sortBy: String): MutableList<Project> {
        return projectRepository.findAll(Sort.by(sortBy).descending())
    }

    fun getProjectById(projectId: String): Project {
        return projectRepository.getById(projectId.toLong())
    }

    fun addNewProject(project: Project): Project {
        return projectRepository.save(project)
    }

    fun deleteProject(projectId: String) {
        return projectRepository.deleteById(projectId.toLong())
    }

    fun updateProject(newProject: Project): Project {
        var oldProject = projectRepository.getById(newProject.id!!)
        oldProject.name = newProject.name
        oldProject.description = newProject.description
        oldProject.rating = newProject.rating
        oldProject.date = newProject.date
        return projectRepository.save(oldProject)
    }
}