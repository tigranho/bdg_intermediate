package com.bdg.Test;
import com.bdg.ArrayList.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class ArrayListTest {

@Test
public void testAdd() {
    List<Person> list = new ArrayList<>();
    Assert.assertTrue(list.isEmpty());
    Assert.assertTrue(list.size()==0);

}
}
