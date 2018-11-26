package com.wk.boot.shop.common.enums;

/**
 * Created by wgp on 2018/11/26.
 */

public enum PersonCommonEnum {

    DIMENSION_ONE(1,"维度1",new String[]{"width","height"}),
    DIMENSION_TWO(2,"维度2",new String[]{"distance","width"}),
    DIMENSION_THREE(3,"维度3",new String[]{"age","gender"}),
    DIMENSION_FOUR(4,"维度4",new String[]{"big","widrh"});
//    DIMENSION_FIVE(5,"维度1",new String[]{"","",""}),
//    DIMENSION_SIX(6,"维度1",new String[]{"","",""}),
//    DIMENSION_SEVEN(7,"维度1",new String[]{"","",""});
     PersonCommonEnum(Integer code,String desc,String[] strs){
        this.code = code;
        this.desc = desc;
        this.columns = strs;
    }
    private String desc;
    private Integer code;
    private String[] columns;

    public String[] getColumns(){
        return this.columns;
    }
    public String getDesc(){
        return this.desc;
    }

    public Integer getCode() {
        return code;
    }
}
