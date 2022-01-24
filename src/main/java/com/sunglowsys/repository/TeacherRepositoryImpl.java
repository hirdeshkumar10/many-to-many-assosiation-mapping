package com.sunglowsys.repository;

import com.sunglowsys.domain.Teacher;
import com.sunglowsys.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.spi.PersistenceUnitTransactionType;
import java.util.List;

public class TeacherRepositoryImpl implements TeacherRepository{

    private static final Logger LOGGER = LoggerFactory.getLogger(TeacherRepositoryImpl.class);

    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @Override
    public Teacher save(Teacher teacher) {
        LOGGER.debug("saving:",teacher);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Long id = (Long) session.save(teacher);
        session.getTransaction().commit();
        session.close();
        return teacher;
    }

    @Override
    public Teacher update(Teacher teacher, Long id) {
        LOGGER.debug("updating: {}",teacher);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher1 = session.get(Teacher.class,id);
        teacher1.setFirstName(teacher.getFirstName());
        session.update(teacher1);
        session.getTransaction().commit();
        session.close();
        return teacher1;
    }

    @Override
    public Teacher findById(Long id) {
        LOGGER.debug("finding by id: {}",id);
        Session session = sessionFactory.openSession();
        Teacher teacher = session.get(Teacher.class,id);
        return teacher;
    }

    @Override
    public List<Teacher> findAll() {
        LOGGER.debug("finding all: {}");
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from teacher");
        List<Teacher > teacherList = query.list();
        return teacherList;
    }

    @Override
    public void delete(Long id) {
        LOGGER.debug("deleting : {}",id);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Teacher teacher = session.get(Teacher.class,id);
        session.delete(teacher);
        session.getTransaction().commit();
        session.close();
        System.out.println("deleted:"+teacher);

    }
}
