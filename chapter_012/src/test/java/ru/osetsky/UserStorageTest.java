package ru.osetsky;


import org.junit.Test;

public class UserStorageTest {

    @Test
    public void whenAddUserToStorageShouldSafeIt() {
        MemoryStorage memory = new MemoryStorage();
        UserStorage storage = new UserStorage(memory);
        storage.add(new User());
    }

}
