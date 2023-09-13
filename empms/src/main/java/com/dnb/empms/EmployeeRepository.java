package com.dnb.empms;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

	//Select * from employee where dept=''
	List<Employee> findByDept(String deptName);
	//Select 8 from employee where salary>?
	List<Employee> findBySalaryGreaterThan(int salary);
	//Select * from employee where dept=? and salary<?
	List<Employee> findByDeptAndSalaryLessThan(String deptName, int salary);
	//Select top 1 * from employee order by salary desc
	Optional<Employee> findTopByOrderBySalaryDesc();
	
	Employee findTopByOrderBySalaryAsc();
	
	List<Employee>findTop3ByOrderBySalaryDesc();
	
	List<Employee>findTop3ByOrderBySalaryAsc();
	
	List<Employee>findFirst2BySalary(int Salary);
	
	List<Employee>findFirst2ByDeptOrderBySalaryDesc(String deptName);
	//Select *from Employee
	List<Employee>findBy();
	//select *from Employee where salary between ? and ?
	List<Employee>findBySalaryBetween(int a,int b);
	
	List<Employee>findByNameLike(String likeString);
	List<Employee>findByDeptLike(String likeString);
	
	long countByDept(String deptName);
	
	//select dept,max(salary) from employee groupby dept
	@Query("SELECT e.dept, MAX(e.salary) FROM Employee e GROUP BY e.dept")
	List<Object[]> findMaxSalaryByDept();
}
