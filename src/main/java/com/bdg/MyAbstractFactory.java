package com.bdg;

public class MyAbstractFactory {

    public static void main(String[] args) {
        Factorys breadFactory=new AbstrctFactory().creatFactorys("Bread");
        Factorys gumFactory=new AbstrctFactory().creatFactorys("Gum");
        Breads withBreaad=breadFactory.creatBread("White");
        Gum sweetGum=gumFactory.creatGum("Sweet");
        withBreaad.breadType();
        sweetGum.gumType();
    }
}


interface Breads {
    void breadType();
}

class WhiteBreads implements Breads {

    public void breadType() {
        System.out.println("It is white bread");
    }
}

class BlackBreads implements Breads {

    public void breadType() {
        System.out.println("It is black bread");
    }
}

class BreadFactory implements Factorys {
    public Breads creatBread(String bread) {
        if ("White".equals(bread)) {
            return new WhiteBreads();
        } else if ("Black".equals(bread)) {
            return new BlackBreads();
        } else {
            return null;
        }

    }

    public Gum creatGum(String typeOfGum) {
        return null;
    }
}

interface Gum {
    void gumType();
}

class Sweet implements Gum {

    public void gumType() {
        System.out.println("This gum is sweet");
    }


}

class SugerFree implements Gum {

    public void gumType() {
        System.out.println("This gum is sugarfree");
    }
}

class GumsFactory implements Factorys {
    public Breads creatBread(String typeOfBread) {
        return null;
    }

    public Gum creatGum(String gum) {
        if ("Sweet".equals(gum)) {
            return new Sweet();
        } else if ("Sugarfree".equals(gum)) {
            return new SugerFree();
        } else {
            return null;
        }

    }
}

interface Factorys {
Breads creatBread(String typeOfBread);
Gum creatGum(String typeOfGum);
}

 class AbstrctFactory {
Factorys creatFactorys(String typeOfFactory){
    if ("Bread".equals(typeOfFactory)) {
        return new BreadFactory();
    } else if ("Gum".equals(typeOfFactory)) {
        return new GumsFactory();
    }
    else {
        return null;
    }

}
}