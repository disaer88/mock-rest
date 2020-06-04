package com.cancelpwnz.mockback.utils;


import com.cancelpwnz.mockback.model.Employee;

public class EmployeeUtils {

    public static com.cancelpwnz.mockback.dao.Employee fillEditableParams(com.cancelpwnz.mockback.dao.Employee target, Employee s){
        target.setAge(s.getAge());
        target.setMarried(s.getMarried());
        target.setName(s.getName());
        target.setStartWorkSt(s.getStartWorkSt());
        target.setChief(s.getChief() != null && s.getChief().getId() != null ? new com.cancelpwnz.mockback.dao.Employee().setId(s.getChief().getId()) : null);
        return target;
    }

    public static Employee convert(com.cancelpwnz.mockback.dao.Employee source){
        if (source == null){
            return null;
        }
        Employee employee = new Employee()
                .setAge(source.getAge())
                .setId(source.getId())
                .setMarried(source.getMarried())
                .setName(source.getName())
                .setStartWorkSt(source.getStartWorkSt());
        if (employee != null && employee.getId() != null){
            employee.setChief(convert(source.getChief()));
        }
        return employee;
    }

    public static void thorIfRecursive(Employee req){
        if (req.getId() == null || req.getChief() == null || req.getChief().getId() == null){
            return;
        } else {
            if (req.getId().compareTo(req.getChief().getId()) == 0){
                throw new RuntimeException("Recursive employee hierarchy");
            }
        }
    }

}
