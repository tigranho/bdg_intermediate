package com.bdg;

import java.lang.reflect.Method;

/**
 * @author Tigran
 */
public class ReflectionTest {

    public static void main(String[] args)  throws Exception {
        Class c = Class.forName("com.bdg.Main");

        Main  main =  (Main) c.newInstance();

        Method m  = c.getDeclaredMethod("test" , null);

        m.setAccessible(true);
        m.invoke(main,null);

    }



}
