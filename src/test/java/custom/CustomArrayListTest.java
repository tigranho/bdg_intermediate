package custom;


import org.junit.Assert;
import org.junit.Test;

public class CustomArrayListTest {
    @Test
    public void testArrayListIsEmpty() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        Assert.assertTrue(list.isEmpty());

    }

    @Test
    public void testArrayListSize() {
        CustomArrayList<Integer> list = new CustomArrayList<>();
        list.add(5);
        Assert.assertTrue(list.size() == 1);
    }

    @Test
    public void testArrayListAdd() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("One");
        list.add("Two");
        list.add("Three");
        Assert.assertTrue(list.size() == 3);


    }

    @Test
    public void testArrayListGet() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("m");
        list.add("jm");
        Assert.assertEquals("jm", list.get(1));
        Assert.assertTrue(list.size() == 2);
    }

    @Test
    public void testArrayListContains() {
        CustomArrayList<String> list=new CustomArrayList<>();
        list.add("aa");
        list.add("dcfg");
        Assert.assertTrue(list.contains("dcfg"));

    } @Test
    public void testArrayListRemove(){
        CustomArrayList<Integer> list =new CustomArrayList<>();
        list.add(3);
        list.add(6);
        list.add(9);
        list.remove(1);
        Assert.assertFalse(list.size()==3);

    }
    @Test
    public void testArrayListClear(){
        CustomArrayList<Integer> list =new CustomArrayList<>();
        list.add(5);
        list.add(7);
        list.add(9);
        list.clear();
        Assert.assertTrue(list.size()==0);

    }
    @Test
     public void testArrayListSet(){
         CustomArrayList<String> list =new CustomArrayList<>();
         list.add("hm");
         list.add("gv");
         list.set(0,"hb");
         Assert.assertEquals("hb",list.get(0));


     }
}
