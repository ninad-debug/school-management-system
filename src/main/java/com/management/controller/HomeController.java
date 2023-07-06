package com.management.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.management.dao.StudentDao;
import com.management.entity.Student;

@Controller
public class HomeController {

	@Autowired
	private StudentDao empDao;

	@RequestMapping(path = "/home")
	public String home(Model m) {

		List<Student> list = empDao.getAllEmp();
		m.addAttribute("empList", list);
		return "home";
	}

	@RequestMapping(path = "/addStudent")
	public String addEmp() {
		return "add_student";
	}

	@RequestMapping(path = "/createStudent", method = RequestMethod.POST)
	public String createEmp(@ModelAttribute Student emp, HttpSession session) {
		System.out.println(emp);

		int i = empDao.saveEmp(emp);
		session.setAttribute("msg", "Register Sucessfully");
		return "redirect:/addStudent";
	}

	@RequestMapping(path = "/editStudent/{id}")
	public String editEmp(@PathVariable int id, Model m) {

		Student emp = empDao.getEmpById(id);
		m.addAttribute("emp", emp);
		return "edit_student";
	}

	@RequestMapping(path = "/updateStudent", method = RequestMethod.POST)
	public String updateEmp(@ModelAttribute Student emp, HttpSession session) {

		empDao.update(emp);
		session.setAttribute("msg", "Update Sucessfully");
		return "redirect:/home";
	}

	@RequestMapping("/deleteStudent/{id}")
	public String deleteEmp(@PathVariable int id, HttpSession session) {
		empDao.deleteEmp(id);
		session.setAttribute("msg", "Student Delete Sucesfully");
		return "redirect:/home";
	}

}
