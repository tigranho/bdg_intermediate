import com.bdg.generic.list.CustomArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class CustomArrayListTest {

    @BeforeEach
    public CustomArrayList<String> customArrayList() {
        return new CustomArrayList<>();
    }


    @Test
    public void addElement() {
      customArrayList().add("test");
      customArrayList().add("test1");
    }
}
