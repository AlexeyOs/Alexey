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
     * @param valueOld is type T.
     * @param valueNew is type T.
     */
    void update(T valueOld, T valueNew);

    /**
     * Method delete.
     * @param value is type T.
     */
    void delete(T value);
}
