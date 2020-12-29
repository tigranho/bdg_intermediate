package com.bdg;
//Singleton
 class DesinPaterrnSingle {
    private static  final DesinPaterrnSingle singleton=new DesinPaterrnSingle();
    private DesinPaterrnSingle(){
    }
    public static DesinPaterrnSingle getsingleton(){
        return singleton;
    }

}
