package com.bdg.homework.functionalInterfaces.practiseSupplier;

import java.util.Comparator;
import java.util.function.Supplier;

public class SupplierTest implements Comparator<String> {


 

    @Override
    public int compare(String o1, String o2) {


        return o1.length() - o2.length();

    }


}

class Use {


}
