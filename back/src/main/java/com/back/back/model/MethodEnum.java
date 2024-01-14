package com.back.back.model;

public enum MethodEnum {
    Money((short)1),
    CardCash((short)2),
    CardLater((short)3);

    private final short value;

    MethodEnum(short value){
        this.value = value;
    }

    public short getValue(){
        return value;
    }
}
