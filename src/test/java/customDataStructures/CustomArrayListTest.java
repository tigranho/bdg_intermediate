package customDataStructures;

import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListTest {

    @Test
    public void testListInit() {
        CustomArrayList<String> list = new CustomArrayList<>();
        Assert.assertTrue(list.isEmpty());

    }

    @Test
    public void testAdd() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Hello");
        list.add("Mello");
        list.add("Bello");

        Assert.assertEquals("Bello", list.get(2));

    }

}
