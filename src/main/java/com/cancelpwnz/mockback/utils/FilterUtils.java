package com.cancelpwnz.mockback.utils;

import com.cancelpwnz.mockback.dao.EmployeeFilter;
import com.cancelpwnz.mockback.model.request.Filter;
import org.springframework.beans.BeanUtils;

public class FilterUtils {

    public static EmployeeFilter convert(Filter source){
        EmployeeFilter target = new EmployeeFilter();
        BeanUtils.copyProperties(source,target);
        return target;
    }

}
