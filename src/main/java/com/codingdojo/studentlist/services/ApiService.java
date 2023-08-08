package com.codingdojo.studentlist.services;

import com.codingdojo.studentlist.models.Info;
import com.codingdojo.studentlist.models.Student;
import com.codingdojo.studentlist.repositories.InfoRepository;
import com.codingdojo.studentlist.repositories.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApiService {
    private final StudentRepository studentRepository;
    private final InfoRepository infoRepository;

    public ApiService(StudentRepository studentRepository, InfoRepository infoRepository) {
        this.studentRepository = studentRepository;
        this.infoRepository = infoRepository;
    }

    //Servicios de Student
    //Obtener todos los estudiantes
    public List<Student> allStudents() {
        return studentRepository.findAll();
    }

    //Crear estudiante
    public Student createStudent(Student s) {
        return studentRepository.save(s);
    }

    //Devolver un estudiante por Id
    public Student findStudent(Long id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        if (optionalStudent.isPresent()) {
            return optionalStudent.get();
        } else {
            return null;
        }
    }

    //Servicios de Info
    //Obtener todas las info (Para probar, tests, no puedo hacer andar el findAll() generico para ver todas las infos, solo con Query funciona
    public List<Info> allInfos() {
        return infoRepository.findAll();
    }
    //Crear info
    public Info createInfo(Info i){
        return infoRepository.save(i);
    }
}
