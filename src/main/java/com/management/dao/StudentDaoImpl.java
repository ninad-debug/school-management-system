package com.management.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.management.entity.Student;

@Repository
public class StudentDaoImpl implements StudentDao {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public int saveEmp(Student emp) {

		int i = (Integer) hibernateTemplate.save(emp);

		return i;
	}

	public Student getEmpById(int id) {
		Student emp = hibernateTemplate.get(Student.class, id);
		return emp;
	}

	public List<Student> getAllEmp() {
		List<Student> list = hibernateTemplate.loadAll(Student.class);
		return list;
	}

	@Transactional
	public void update(Student emp) {
		hibernateTemplate.update(emp);

	}

	@Transactional
	public void deleteEmp(int id) {
		Student emp = hibernateTemplate.get(Student.class, id);
		hibernateTemplate.delete(emp);
	}

}
