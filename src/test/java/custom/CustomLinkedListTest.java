package custom;

import org.junit.Assert;
import org.junit.Test;

public class CustomLinkedListTest {

    @Test
    public void testLinkedListIsEmpty(){
        CustomLinkedList<String> list=new CustomLinkedList<>();
        list.add("zzx");
        Assert.assertFalse(list.isEmpty());

    }
    @Test
    public void testLinkedListSize(){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(6);
        Assert.assertFalse(list.size()==0);
    }

    @Test
    public  void testLinkedListAdd(){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(2);
        list.add(6);
        list.add(8);
        Assert.assertFalse((list.size()==0));
    }

    @Test
    public void testLinkedLIstGet(){
        CustomLinkedList<String> list=new CustomLinkedList<>();
        list.add("m");
        list.add("jm");
        Assert.assertEquals("jm", list.get(1));
        Assert.assertTrue(list.size() == 2);
    }

   // @Test
   /* public void testLinkedListAddIndex(){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(0,4);
        list.add(1,1);
        Assert.assertTrue(list.size()==2);
    }*/
    @Test
    public  void  testLinkedListRemove(){
        CustomLinkedList<Integer> list=new CustomLinkedList<>();
        list.add(3);
        list.add(6);
        list.add(9);
        list.remove(1);
        Assert.assertFalse(list.size()==3);
    }
}
