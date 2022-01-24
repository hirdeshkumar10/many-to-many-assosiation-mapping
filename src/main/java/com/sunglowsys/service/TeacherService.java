package com.sunglowsys.service;

import com.sunglowsys.domain.Subject;
import com.sunglowsys.domain.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher save(Teacher teacher);

    Teacher update(Teacher teacher,Long id);

    Teacher findById(Long id);

    List<Teacher> findAll();

    void delete(Long id);
}
