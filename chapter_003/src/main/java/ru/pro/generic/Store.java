package ru.pro.generic;



/**
 * Created by koldy on 08.09.2017.
 * @param <T> is extends Base.
 */
public interface Store<T extends Base> {
    /**
     * Method add.
     * @param value is type T.
     */
    void add(T value);

    /**
     * Method update.
     * @param indexObject is type integer.
     * @param object is type T.
     */
    void update(int indexObject, T object);

    /**
     * Method delete.
     * @param objectIndex is type integer.
     */
    void delete(int objectIndex);
}
