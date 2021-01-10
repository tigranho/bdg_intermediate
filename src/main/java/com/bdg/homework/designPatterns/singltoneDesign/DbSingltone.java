package com.bdg.homework.designPatterns.singltoneDesign;

import java.sql.DriverManager;

public class DbSingltone {

    /* we are going to crate singlton object , and i prefer to write in lazy type
     **/
    private static DbSingltone static_dbSingltone = null;

    private DbSingltone() {
     }

    /* This type of initialization we call lazy loading
     * As  you see we are talking about db and it is obvious that we have to care about
     * if the our singltone is syncronized or not
     *
     * */
    public static DbSingltone getInstance() {
        if (static_dbSingltone == null) {
            synchronized (DbSingltone.class) {
                if (static_dbSingltone == null)    // here i wrote twice because in the above if we dont know our object is safe or not
                    static_dbSingltone = new DbSingltone();
            }
        }
        return static_dbSingltone;
    }
}
