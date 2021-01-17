package com.wind.dto;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * @ClassName BaseDTO
 * @Description TODO
 * @Author xiaowj
 * @Date DATE{TIME}
 */
public class BaseDTO implements java.io.Serializable {
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
