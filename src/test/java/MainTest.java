import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Тест Main класса
 */
public class MainTest {
  @Test
  public void cleanList3AndMoreOneByOne() throws Exception {
    //prepare
    List<Long> list = new ArrayList<>();
    list.addAll(Arrays.asList(new Long[]{1l, 2l, 2l, 2l, 1l, 0l, 0l, 0l, 2l}));

    //test
    System.out.println("cleanList3AndMoreOneByOne got: "+ list);
    new Worker<Long>().cleanList3AndMoreOneByOne(list);
    System.out.println("cleanList3AndMoreOneByOne result: "+ list);

    //check
    assertTrue(list.size() == 2);
    assertTrue(list.get(0) == 1);
    assertTrue(list.get(1) == 1);
  }

  @Test
  public void cleanList3AndMoreRandom() throws Exception {
    //prepare
    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(new Integer[]{2, 1, 2, 0, 2}));

    //test
    System.out.println("cleanList3AndMoreRandom got: " + list);
    new Worker().cleanList3AndMoreRandom(list);
    System.out.println("cleanList3AndMoreRandom result: " + list);

    //check
    assertTrue(list.size() == 2);
    assertTrue(list.contains(0));
    assertTrue(list.contains(1));
  }
}