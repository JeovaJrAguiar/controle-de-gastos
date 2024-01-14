package com.back.back.model;

public enum FlagEnum {
    Visa((short) 1),
    MasterCard((short) 2),
    AmericanExpress((short) 3),
    ELO((short) 4);

    private final short value;

    public short getValue(){
        return value;
    }
    FlagEnum(short value){
        this.value = value;
    }

    public static FlagEnum fromValue(short value) {
        for (FlagEnum flag : FlagEnum.values()) {
            if (flag.getValue() == value) {
                return flag;
            }
        }
        throw new IllegalArgumentException("Valor de FlagEnum inválido: " + value);
    }

    public static short fromValueString(String value) {
        if ("Visa".equalsIgnoreCase(value)) {
            return 1;
        } else if ("MasterCard".equalsIgnoreCase(value)) {
            return 2;
        } else if ("AmericanExpress".equalsIgnoreCase(value)) {
            return 3;
        } else if ("ELO".equalsIgnoreCase(value)) {
            return 4;
        } else {
            throw new IllegalArgumentException("Valor de FlagEnum inválido: " + value);
        }
    }
}
