
package com.eutraining.hllolluni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@RestController
@RequestMapping("api/employees")
public class JavaNinthAssignmentApplication {
	static List<Employee> employees = new ArrayList<>();

	public static void main(String[] args) {
		Employee employee1 = new Employee(1, "Haxhi Llolluni", "IT");
		Employee employee2 = new Employee(2, "Filan Fisteku", "HR");
		employees.add(employee1);
		employees.add(employee2);
		SpringApplication.run(JavaNinthAssignmentApplication.class, args);
	}

	@GetMapping
	public List<Employee> getEmployees(){
		return employees;
	}

	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable int id) {
		Optional<Employee> employee = employees.stream().filter(b -> b.getId() == id).findFirst();
		if (employee.isPresent()) {
			return employee.get();
		} else{
			throw new RuntimeException("Employee not found!");
		}
	}

	@PostMapping("/newemployee")
	public Employee addNewEmployee(@RequestBody Employee employee){
		employees.add(employee);
		return employee;
	}

}
