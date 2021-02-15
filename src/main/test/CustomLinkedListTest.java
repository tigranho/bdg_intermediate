package test;

import com.bdg.custom_collections.CustomArrayList;
import org.junit.Assert;
import org.junit.Test;
import java.util.Random;

public class CustomLinkedListTest {

    @Test
    public void testCustomLinkedListInit(){
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();

        Assert.assertTrue(linkedList.isEmpty());
        Assert.assertEquals(0, linkedList.size());
    }

    @Test
    public void testCustomLinkedListSize() {
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        int randomNumber = new Random().nextInt(1000);

        for (int i = 0; i < randomNumber ; i++) {
            linkedList.add(10);
        }
        Assert.assertEquals(randomNumber, linkedList.size());
    }

    @Test
    public void testCustomLinkedListIsEmpty() {
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        linkedList.add(15);

        Assert.assertNotEquals(0,linkedList.size());
    }

    @Test
    public void testCustomLinkedListIsContains(){
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        linkedList.add(15);
        Assert.assertTrue(linkedList.contains(15));
    }

    @Test
    public void testCustomLinkedListIsAdd () {
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);

        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void testCustomLinkedListIsGet() {
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        int randomNumber = new Random().nextInt(1000);

        for (int i = 0; i < randomNumber ; i++) {
            linkedList.add(randomNumber + i);
            Assert.assertEquals(randomNumber + i, (long)linkedList.get(i));
        }
        Assert.assertEquals(randomNumber, linkedList.size());
    }

    @Test
    public void testCustomLinkedListIsSet() {
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        linkedList.set(0,15);
        linkedList.set(2,12);
        Assert.assertEquals(12, (int) linkedList.get(2));
    }

    @Test
    public void testCustomLinkedListRemove() {
        CustomArrayList<Integer> linkedList = new CustomArrayList<>();
        linkedList.add(15);
        linkedList.add(14);
        linkedList.add(1);

        linkedList.remove(1);

        Assert.assertEquals(1, (int) linkedList.get(1));
    }
}
