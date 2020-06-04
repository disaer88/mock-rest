package com.cancelpwnz.mockback.services;

import com.cancelpwnz.mockback.dao.EmployeeRepository;
import com.cancelpwnz.mockback.dao.EmployeeSpecification;
import com.cancelpwnz.mockback.error.EmployeeNotFound;
import com.cancelpwnz.mockback.model.Employee;
import com.cancelpwnz.mockback.model.request.Filter;
import com.cancelpwnz.mockback.model.response.Page;
import com.cancelpwnz.mockback.utils.EmployeeUtils;
import com.cancelpwnz.mockback.utils.FilterUtils;
import com.cancelpwnz.mockback.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.Instant;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;
    private final EmployeeSpecification spec;

    @Override
    public Employee edit(Employee e) {
        com.cancelpwnz.mockback.dao.Employee db = repo.findById(e.getId()).orElseThrow(()->new EmployeeNotFound(e.getId().toString()));
        return EmployeeUtils.convert(repo.save(EmployeeUtils.fillEditableParams(db,e)));
    }

    @Override
    public Employee save(Employee e) {
        com.cancelpwnz.mockback.dao.Employee entity = new com.cancelpwnz.mockback.dao.Employee();
        entity.setStartWorkSt(Instant.now());
        return EmployeeUtils.convert(repo.save(EmployeeUtils.fillEditableParams(entity,e)));
    }

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository repo, EmployeeSpecification spec) {
        this.repo = repo;
        this.spec = spec;
    }

    @Override
    public Employee findById(Long id){
        return EmployeeUtils.convert(repo.findById(id).orElseThrow(()->new EmployeeNotFound(id.toString())));
    }

    @Override
    public void deleteById(Long id){
        repo.delete(repo.findById(id).orElseThrow(()->new EmployeeNotFound(id.toString())));
    }

    @Override
    public Page<Employee> findAll(Filter filter, Pageable pageable){
        return PageUtils.convert(repo.findAll(spec.getFilter(FilterUtils.convert(filter)), pageable), EmployeeUtils::convert);
    }

}
