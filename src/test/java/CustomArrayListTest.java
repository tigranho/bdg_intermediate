import com.bdg.homework.generic.list.CustomArrayList;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class CustomArrayListTest {



    @Before
    public CustomArrayList<String> customArrayList() {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("test1");
        list.add("test2");
        list.add("test3");
        return list;
    }

    @Test
    public void addElement() {
        Assertions.assertTrue(customArrayList().add("test"));
        Assertions.assertTrue(customArrayList().add("test1"));
    }

    @Test
    public  void removeElement(){
        Assertions.assertTrue(customArrayList().remove("test1"));
        Assertions.assertFalse(customArrayList().remove("test"));
    }

    @Test
    public  void  checkSize(){
        Assertions.assertNotEquals(customArrayList().size(), 0);
        Assertions.assertEquals(customArrayList().size(),3);
    }


}
