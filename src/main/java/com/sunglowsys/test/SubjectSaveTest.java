package com.sunglowsys.test;

import com.sunglowsys.domain.Subject;

import com.sunglowsys.domain.Teacher;

import com.sunglowsys.service.SubjectService;
import com.sunglowsys.service.SubjectServiceImpl;
import com.sunglowsys.service.TeacherServiceImpl;

import java.util.ArrayList;

import java.util.List;

public class SubjectSaveTest {

    public static void main(String[] args) {

        Subject subject1 = new Subject("Hindi","h1210");
        Subject subject2 = new Subject("Mathematics","M7586");
        Subject subject3 = new Subject("Science","S7666757");
        SubjectService subjectService = new SubjectServiceImpl();
        subjectService.save(subject1);
        subjectService.save(subject2);
        subjectService.save(subject3);

        List<Subject> subjects = subjectService.findAll();


        Teacher teacher = new Teacher("Surendra","Singh","ss@gmail.com","8768798727");
        teacher.setSubjectList(subjects);
        Teacher teacher1 = new TeacherServiceImpl().save(teacher);
        System.out.println(teacher1);




    }
}
