package com.cancelpwnz.mockback.config;

import com.cancelpwnz.mockback.model.request.EmployeeSortFiled;
import com.cancelpwnz.mockback.model.request.Sort;
import com.cancelpwnz.mockback.model.request.SortType;
import org.springframework.core.convert.converter.Converter;


public class StringToSortConverter implements Converter<String, Sort<EmployeeSortFiled>> {

    @Override
    public Sort<EmployeeSortFiled> convert(String s) {
        String[] split = s.split(",");
        if (split.length < 4 || !split[0].equalsIgnoreCase("type")) {
            return null;
        } else {
            Sort<EmployeeSortFiled> result = new Sort<>();
            result.setType(split[1].equalsIgnoreCase("ASC")?SortType.ASC:SortType.DESC);
            result.setField(EmployeeSortFiled.valueOf(split[3].toUpperCase()));
            return result;
        }
    }
}
