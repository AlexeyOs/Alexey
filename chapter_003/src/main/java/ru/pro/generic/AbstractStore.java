package ru.pro.generic;

/**
 * Created by koldy on 15.09.2017.
 * @param <E> is generic for methods: add, update, delete.
 */
public abstract class AbstractStore<E extends Base> implements Store<E> {
    /**
     * Field size is constant of type integer.
     */
    private final int size = 10;

    /**
     * sim is object of class SimpleArray.
     */
    private SimpleArray<Base> simpleArray = new SimpleArray<>(size);
    /**
     * Array objects.
     */
    private Object[] objects;
    /**
     * Field index is type integer.
     */
    private int index = 0;

//    /**
//     * Constructor SimpleArray.
//     * @param size for initialize object.
//     */
//    public SimpleArray(int size) {
//        this.objects = new Object[size];
//    }

    /**
     * Field index is type integer.
     * @param value is new value, which add to objects.
     */
    @Override
    public void add(E value)  {
        this.simpleArray.add(value);
    }

    /**
     * Method get.
     * @param indexObject indicate on object.
     * @return object, which  request.
     */
    public E get(int indexObject) {
        return (E) this.simpleArray.get(indexObject);
    }

    /**
     * Method update.
     * @param indexObject indicate on object, which will update.
     * @param object which will update.
     */
    @Override
    public void update(int indexObject, E object) {
        this.simpleArray.update(indexObject, object);
    }

    /**
     * Method delete.
     * @param objectIndex indicate on object, which will delete.
     */
    @Override
    public void delete(int objectIndex) {
        this.simpleArray.delete(objectIndex);
    }

    public SimpleArray<Base> getSim() {
        return this.simpleArray;
    }
}
