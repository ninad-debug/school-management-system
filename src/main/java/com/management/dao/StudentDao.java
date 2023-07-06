package com.management.dao;

import java.util.List;

import com.management.entity.Student;

public interface StudentDao {

	public int saveEmp(Student emp);

	public Student getEmpById(int id);

	public List<Student> getAllEmp();

	public void update(Student emp);

	public void deleteEmp(int id);

}
