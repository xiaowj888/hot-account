package com.wind.enums;

/**
 * @ClassName AtomTypeEnum
 * @Description 产品状态枚举
 * @Author xiaowj
 * @Date 20210116
 */
public enum ProductStatusEnum {
    //产品状态枚举
    NORMAL(1,"正常"),
    DELETED(-1,"删除"),
    DISABLED(0,"禁用"),
    ;
    private int status;
    private String desc;

    ProductStatusEnum(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }
}
