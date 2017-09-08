package ru.pro.generic;



/**
 * Created by koldy on 07.09.2017.
 * @param <E> is generic.
 *
 */
public class SimpleArray<E> {
    /**
     * Array objects.
     */
    private Object[] objects;

    /**
     * Field index is type integer.
     */
    private int index = 0;

    /**
     * Constructor SimpleArray.
     * @param size for initialize object.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * Field index is type integer.
     * @param value is new value, which add to objects.
     */
    public void add(E value)  {
        this.objects[index++] = value;
    }

    /**
     * Method get.
     * @param indexObject indicate on object.
     * @return object, which  request.
     */
    public E get(int indexObject) {
        return (E) this.objects[indexObject];
    }

    /**
     * Method update.
     * @param indexObject indicate on object, which will update.
     * @param object which will update.
     */
    public void update(int indexObject, E object) {
     this.objects[indexObject] = object;
    }

    /**
     * Method delete.
     * @param objectIndex indicate on object, which will delete.
     */
    public void delete(int objectIndex) {
        this.objects[objectIndex] = null;
    }

}
