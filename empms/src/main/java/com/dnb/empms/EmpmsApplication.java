package com.dnb.empms;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EmpmsApplication {
	
	public static void main(String[] args) {
		
		
		ApplicationContext applicationContext =SpringApplication.run(EmpmsApplication.class, args);
		EmployeeRepository employeeRepository= applicationContext.getBean(EmployeeRepository.class);
	
		Employee employee=new Employee("Bhuvana","Tech",1000);
		//employeeRepository.save(employee);
		//System.out.println(employeeRepository.countByDept("Tech")); 
//		System.out.println(employeeRepository.findBySalaryGreaterThan(10));
		List<Object[]>list=employeeRepository.findMaxSalaryByDept();
		
		
		list.forEach((e)->{
			System.out.println(Arrays.toString(e)); 
		});
//		
	}

}
