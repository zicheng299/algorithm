package com.demo.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;
@Mapper
public interface CommonMapper {

    BigDecimal selectSecondSalary();

}
