import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс с методами очистки Листа от повторяющихся элементов
 */
public class Worker<T> {
    final static int MAGIC_NUMBER = 3;
  /**
   * Удалить из List числа, повторяющиеся три и больше раз подряд
   */
  public void cleanList3AndMoreOneByOne(List<T> list) {
    final HashMap<T, Integer> sameCount = new HashMap<>(); // хранит элемент листа и счетчик повторов
    final Object[] lastNumber = {null}; // хранит предыдущее эначение
    // заполняем мапу счетчиком элементов в list
    list.forEach( (v)-> {
      Integer counter = sameCount.containsKey(v) ? sameCount.get(v) : 0;
      sameCount.put(v, v.equals(lastNumber[0]) || counter >= MAGIC_NUMBER ? counter + 1 : 1);
      lastNumber[0] = v;
    } );
    // создаем список элементов для удаления
    List<T> toRemove = list
            .stream()
            .filter( (v)-> sameCount.get(v) >= MAGIC_NUMBER)
            .collect(Collectors.toList() );
    list.removeAll(  toRemove );
  }

  /**
   * Удалить из List числа, повторяющиеся три и больше раз не обязательно подряд
   */
  public void cleanList3AndMoreRandom(List<T> list) {
    final HashMap<T, Integer> sameCount = new HashMap<>(); // хранит элемент листа и счетчик повторов
    // заполняем мапу счетчиком элементов в list
    list.forEach( (v)-> sameCount.put(v, sameCount.containsKey(v) ? sameCount.get(v) + 1 : 1 ) );
    // создаем список элементов для удаления
    List<T> toRemove = list
            .stream()
            .filter((v)-> sameCount.get(v) >= MAGIC_NUMBER)
            .collect(Collectors.toList());
    list.removeAll(  toRemove );
  }
}
