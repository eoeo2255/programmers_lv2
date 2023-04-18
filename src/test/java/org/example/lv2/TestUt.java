package org.example.lv2;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestUt {

    public static Object call(Object obj, String methodName, Object... args) {
        try {
            Class<?>[] argTypes = new Class<?>[args.length];
            for (int i = 0; i < args.length; i++) {
                argTypes[i] = args[i].getClass();
            }

            Method method = obj.getClass().getDeclaredMethod(methodName, argTypes);
            method.setAccessible(true);
            return method.invoke(obj, args);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
