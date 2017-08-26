package ru.osetsky.testcollections;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;
 /**
   * Created by koldy on 14.07.2017.
   */
public class TestTestPerfomanceCollections {
    /**
     * Method is testSpeedAddAndDeleteList .
     */
    @Test
    public void testSpeedAddAndDeleteList() {
         TestPerfomanceCollections test = new TestPerfomanceCollections();
         List<String> list = new LinkedList<String>();
         System.out.println(test.add(list, 1000000));
         System.out.println(test.delete(list, 1000000));
     }
    /**
      * Method is testSpeedAddAndDeleteArr.
      */
    @Test
    public void testSpeedAddAndDeleteArr() {
          TestPerfomanceCollections test = new TestPerfomanceCollections();
          List<String> arr = new ArrayList<String>();
          System.out.println(test.add(arr, 1000000));
          System.out.println(test.delete(arr, 1000000));
      }
    /**
      * Method is testSpeedAddAndDeleteTree.
      */
    @Test
    public void testSpeedAddAndDeleteTree() {
        TestPerfomanceCollections test = new TestPerfomanceCollections();
        TreeSet<String> tree = new TreeSet<String>();
        System.out.println(test.add(tree, 1000000));
        System.out.println(test.delete(tree, 1000000));
    }
     /**
      * LinkedList add:238     delete:39
      * ArrayList  add:954     delete:116
      * TreeSet    add:112     delete:133555
      * Лучшее время показал массив LinkedList, так как
      * там было удаление с начала списка, похуже результат показал ArrayList
      * И дольше всего по сумме времени добавление и удаления показал себя TreeSet,
      * очень долго выполялось удаление, так как много времени уходило на перемещение по дереву(массив TreeSet)
      */
 }
