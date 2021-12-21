package it.nttdata.myschool.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String surname;
    private Integer age;
    @ManyToOne
    @JoinColumn(name="schoolClass_id")
    private SchoolClass schoolClass;

    /* CONSTRUCTORS */

    public Student() {}

    public Student(String name, String surname, Integer age, SchoolClass schoolClass) {
        this.name= name;
        this.surname = surname;
        this.age = age;
        this.schoolClass = schoolClass;
    }

    /* GETTERS & SETTERS */

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }
    public SchoolClass getSchoolClass() {
        return schoolClass;
    }
    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

}
