package com.cancelpwnz.mockback.services;

import com.cancelpwnz.mockback.model.Employee;
import com.cancelpwnz.mockback.model.request.Filter;
import com.cancelpwnz.mockback.model.response.Page;
import org.springframework.data.domain.Pageable;

public interface EmployeeService {

    Employee findById(Long id);

    Employee edit(Employee e);

    Employee save(Employee e);

    void deleteById(Long id);

    Page<Employee> findAll(Filter filter, Pageable pageable);

}
