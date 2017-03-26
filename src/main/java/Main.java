import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

  public static void main(String[] args)
  {
    List<Integer> list = new ArrayList<>();
    list.addAll(Arrays.asList(new Integer[]{1,2, 2, 2, 1, 2, 1}));

    new Worker<Integer>().cleanList3AndMoreOneByOne(list);

    System.out.println("cleanList3AndMoreOneByOne result: " + list);

    new Worker<Integer>().cleanList3AndMoreRandom(list);

    System.out.println("cleanList3AndMoreRandom result: " + list);
  }


}


