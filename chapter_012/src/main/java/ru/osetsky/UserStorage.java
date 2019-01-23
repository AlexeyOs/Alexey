package ru.osetsky;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserStorage {
    private static final Logger Log = LoggerFactory.getLogger(UserStorage.class);

    private final Storage storage;

    public UserStorage (final Storage storage) {
        this.storage = storage;
    }

    public void add(User user) {
        this.storage.add(user);
    }
}
