package ru.osetsky.stores;


import java.util.List;

/**
 * Created by koldy on 17.01.2019.
 */
public interface CarStore<T> {
    public void addCar(T item);
    public void editCar(T item);
    public void deleteCar(T item);
    public List<T> getAllCars();
}
