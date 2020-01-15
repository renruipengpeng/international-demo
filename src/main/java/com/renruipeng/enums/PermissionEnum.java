package com.renruipeng.enums;

import java.util.HashMap;
import java.util.Map;

public enum PermissionEnum implements IBaseEnum {

    DELETE_STATE(-1,"已删除");

    PermissionEnum(int value, String display){
        this.value=value;
        this.display=display;
    }


    private Integer value;
    private String display;
    private static Map<Integer, PermissionEnum> valueMap = new HashMap<>();

    @Override
    public Integer getValue() {
        return this.value;
    }

    @Override
    public String getDisplay() {
        return this.display;
    }

    static {
        for (PermissionEnum e : PermissionEnum.values()) {
            valueMap.put(e.value, e);
        }
    }

    public static PermissionEnum getByValue(Integer value) {
        PermissionEnum result = valueMap.get(value);
        if (result == null) {
            throw new IllegalArgumentException("No element matches " + value);
        }
        return result;
    }

}
