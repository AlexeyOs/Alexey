package ru.osetsky;

public class MemoryStorage implements Storage {
    @Override
    public void add(User user) {
        System.out.println("store to memory");
    }
}
