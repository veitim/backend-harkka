package syksy2024.harkka2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import syksy2024.harkka2.domain.Student;

@Controller
public class StudentController {

	private static List<Student> studentList = new ArrayList<>();

	static {
		studentList.add(new Student("Urpo", "McTurbo"));
		studentList.add(new Student("Hessu", "Hopo"));
		studentList.add(new Student("Possu", "Sika"));
	}

	@GetMapping("/studentList")
	public String showStudents(Model model) {
		System.out.println("students...");
		model.addAttribute("students", studentList);
		return "studentList";
	}

}
