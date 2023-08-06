package com.codingdojo.studentlist.controllers;

import com.codingdojo.studentlist.models.Info;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.services.ApiService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiController {
    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    //GET para todos los estudiantes
    @GetMapping("/students")
    public List<Student> returnStudents() {
        return apiService.allStudents();
    }

    //POST para cargar persona
    @PostMapping("/students/create")
    public Student create(@RequestParam("firstName") String firstName,
                          @RequestParam("lastName") String lastName,
                          @RequestParam("age") int age) {
        Student student = new Student(firstName, lastName, age);
        return apiService.createStudent(student);
    }

    //POST para asignar info a un estudiante
    @PostMapping("/contacts/create")
    public Info createInfo(@RequestParam("adress") String adress,
                           @RequestParam("city") String city,
                           @RequestParam("state") String state,
                           @RequestParam("student") Student student) {//Debo repasar esto, no entiendo por que recibe por parametro un objeto Student ya que guarda el id de student la clase Info
        Info infoStudent = new Info(adress, city, state, student);
        return apiService.createInfo(infoStudent);
    }

    //GET para mostrar las infos con Query personalizada porque no andaba con el findAll generico
    @GetMapping("/infos")
    public List<Info> mostrarInfos(){
        return apiService.allInfos();
    }
}
