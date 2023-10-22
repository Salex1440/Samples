package org.example.analyzer;

import org.example.Holder;
import org.example.annotation.Max;

import java.lang.reflect.Field;

public class MaxAnnotationAnalyzer {

    public static final Holder HOLDER = new Holder(1);

    public MaxAnnotationAnalyzer() {
        for (Field field : HOLDER.getClass().getDeclaredFields()) {
            System.out.println(field);
            if (field.isAnnotationPresent(Max.class)) {
                field.setAccessible(true);
                int max = field.getAnnotation(Max.class).value();
                int val;
                try {
                    val = field.getInt(HOLDER);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (val > max) {
                    throw new RuntimeException("Value is greater than " + max);
                }
            }
        }
    }

}
