package com.bdg.examples.pattern;

public class BillPughSinglton {
    private BillPughSinglton() {

    }

    public static BillPughSinglton getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {
        private static final BillPughSinglton instance = new BillPughSinglton();
    }

}
