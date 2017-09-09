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
         System.out.println("LinkedList add = "+test.add(list, 1000000));
         System.out.println("LinkedList delete = "+test.delete(list, 1000000));
     }
    /**
      * Method is testSpeedAddAndDeleteArr.
      */
    @Test
    public void testSpeedAddAndDeleteArr() {
          TestPerfomanceCollections test = new TestPerfomanceCollections();
          List<String> arr = new ArrayList<String>();
          System.out.println("ArrayList add = "+test.add(arr, 1000000));
          System.out.println("ArrayList delere = "+test.delete(arr, 1000000));
      }
    /**
      * Method is testSpeedAddAndDeleteTree.
      */
    @Test
    public void testSpeedAddAndDeleteTree() {
        TestPerfomanceCollections test = new TestPerfomanceCollections();
        TreeSet<String> tree = new TreeSet<String>();
        System.out.println("TreeSet add = "+test.add(tree, 1000000));
        System.out.println("TreeSet delete = "+test.delete(tree, 1000000));
    }
     /**
      * LinkedList add:219     delete:47
      * ArrayList  add:115     delete:115083
      * TreeSet    add:732     delete:94
      * 
      * Лучшее время по добавлению показал ArrayList, но в тоже время ArrayList был худшим по
      * удалению элементов из массива, так как каждый раз приходится перебирать весь массив, чтобы удалить один элемент
      * На втором месте по добавление элементов стал LinkedList, и первым по скорости удаления элементов, что логично,
      * так как в двусвязном списке, чтобы удлаить элемент, нужно задействовать только два соседних элемента.
      * На третьем месте по скорости добавления стал TreeSet, и на втором по скорости удаления, такая медленная скорость
      * добавления элементов объясняется необходимостью часто перемещаться с ветки на ветку.
      *
      */
 }
