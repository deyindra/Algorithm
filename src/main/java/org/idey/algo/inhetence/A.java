package org.idey.algo.inhetence;


import java.lang.reflect.ParameterizedType;

public abstract class A<T> {
    private T obj;

    protected A(){
        try {
            Class<T> clazz = (Class<T>)((ParameterizedType)getClass()
                    .getGenericSuperclass()).getActualTypeArguments()[0];
            obj = clazz.newInstance();
        } catch (Exception  e) {
            throw new IllegalArgumentException("No Default Constructor...", e);
        }

    }
}
