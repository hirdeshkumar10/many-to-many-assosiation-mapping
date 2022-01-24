package com.sunglowsys.test;

import com.sunglowsys.repository.SubjectRepositoryImpl;

public class FindByIdSubject {
    public static void main(String[] args) {
        System.out.println(new SubjectRepositoryImpl().findById(1L));
    }
}
