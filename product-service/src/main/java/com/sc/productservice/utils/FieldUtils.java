package com.sc.productservice.utils;

import java.util.function.Consumer;

public class FieldUtils {
    public static void updateIfNotBlank(Consumer<String> setter , String newValue ){
        if(newValue != null && !newValue.isBlank()){
            setter.accept(newValue);
        }
    }
}
