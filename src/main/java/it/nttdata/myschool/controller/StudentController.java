package it.nttdata.myschool.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.nttdata.myschool.model.Student;
import it.nttdata.myschool.repository.SchoolClassRepository;
import it.nttdata.myschool.repository.StudentRepository;

@Controller
public class StudentController {
    
    private SchoolClassRepository schoolClassRepository;
    private StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository, SchoolClassRepository schoolClassRepository) {
        this.studentRepository = studentRepository;
        this.schoolClassRepository = schoolClassRepository;
    }

    @GetMapping("/students")
    public String getClasses(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("title", "Alunni dell'istituto");
        return "students";
    }

    @GetMapping("/students/{name}")
    public String getStudentByClass(Model model, @PathVariable String name) {
       model.addAttribute("title", "Lista studenti " + name);
        //Cosi mi ritorna una lista di una certa sezione
        model.addAttribute("students",studentRepository.findStudentByClass(name) );
        return "students";
    }

    @GetMapping("/newstudent")
    public String getNewStudent(Model model){
        model.addAttribute("schoolclasses", schoolClassRepository.findAll());
        return "newstudent";
    }

    @PostMapping("/newstudent")
    public String postNewStudent(Student student, @RequestParam String schoolclassname){
        student.setSchoolClass(schoolClassRepository.findSchoolClassBySection(schoolclassname));
        studentRepository.save(student);
        return "redirect:/students";
    }

}
