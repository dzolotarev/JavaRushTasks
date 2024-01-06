package com.javarush.task.task32.task3205;

/*
Создание прокси-объекта
*/

import java.lang.reflect.Proxy;

public class Solution {
    public static void main(String[] args) {
        SomeInterfaceWithMethods obj = getProxy();
        obj.stringMethodWithoutArgs();
        obj.voidMethodWithIntArg(1);

        /* expected output
        stringMethodWithoutArgs in
        inside stringMethodWithoutArgs
        stringMethodWithoutArgs out
        voidMethodWithIntArg in
        inside voidMethodWithIntArg
        inside voidMethodWithoutArgs
        voidMethodWithIntArg out
        */
    }

    public static SomeInterfaceWithMethods getProxy() {
        SomeInterfaceWithMethods someInterfaceWithMethods = new SomeInterfaceWithMethodsImpl();
        ClassLoader someInterfaceLoader = someInterfaceWithMethods.getClass().getClassLoader();
        Class<?>[] interfaces = someInterfaceWithMethods.getClass().getInterfaces();
        return (SomeInterfaceWithMethods) Proxy.newProxyInstance(someInterfaceLoader, interfaces, new CustomInvocationHandler(someInterfaceWithMethods));
    }
}