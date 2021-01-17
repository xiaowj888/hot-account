package com.wind.enums;

/**
 * @ClassName AtomTypeEnum
 * @Description 账户原子类型枚举
 * @Author xiaowj
 * @Date 20210116
 */
public enum AtomTypeEnum {
    //余额原子操作类型
    ADD(1,"余额增加"),
    SUB(-1,"余额减少"),
    FROZ(1,"余额冻结"),
    UNFROZ(-1,"余额解冻")
    ;

    private int type;
    private String desc;

    AtomTypeEnum(int type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public int getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }
}
