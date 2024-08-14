package com.code.employee.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.code.employee.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
	//List<Employee> findByName(String name);
	
	//List<Employee> findByDepartmentId(int departmentId);
	
	//List<Employee> findByEmail(String email);
	
	//Using the named query defined in Employee entity
	@Query(name="Employee.findByEmail")
	Employee findByEmailNamed(@Param("email") String email);
	
	//Using the named query defined in Employee entity
	@Query(name="Employee.findByDepartmentId")
	List<Employee> findByDepartmentIdNamed(@Param("departmentId") int departmentId);//under one department there can be many employees
	
	Page<Employee> findAll(Pageable pageable);
	
	Page<Employee> findByDepartmentId(int departmentId, Pageable pageable);
	//@Query("SELECT e.name as name, e.email as email FROM Employee e")
	//List<EmployeeProjection> findByEmployee();

}
