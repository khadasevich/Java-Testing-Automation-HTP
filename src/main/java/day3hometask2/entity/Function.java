package day3hometask2.entity;

import day3hometask2.worker.Engineer;

import java.lang.reflect.InvocationTargetException;

public interface Function {

    Result apply(Engineer engineer) throws ClassNotFoundException, IllegalAccessException, InstantiationException,
            NoSuchFieldException, NoSuchMethodException, InvocationTargetException;

}
