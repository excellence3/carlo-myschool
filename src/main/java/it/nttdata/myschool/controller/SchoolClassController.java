package it.nttdata.myschool.controller;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import it.nttdata.myschool.model.SchoolClass;
import it.nttdata.myschool.repository.SchoolClassRepository;

@Controller
public class SchoolClassController {

    private SchoolClassRepository schoolClassRepository;

    public SchoolClassController(SchoolClassRepository schoolClassRepository) {
        this.schoolClassRepository = schoolClassRepository;
    }

    @GetMapping("/classes")
    public String getClasses(Model model) {
        model.addAttribute("schoolClasses", schoolClassRepository.findAll());
        return "classes";
    }

    @Scheduled(fixedRate = 30000)
    public void helloWorld(){
        System.out.println("I say hello world every 30 seconds!");
    }

    @GetMapping("/newclass")
    public String getNewClass(){
        return "newclass";
    }

    @PostMapping("/newclass")
    public String postNewClass(SchoolClass schoolClass){
        schoolClassRepository.save(schoolClass);
        return "redirect:/classes";
    }
    
}
