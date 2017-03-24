package ru.osetsky.tracker;

/**
 * Created by koldy on 23.03.2017.
 */
public class Task extends Item {
	/**
	 * Constructor Task.
	 */
    public  Task() {
	}
	/**
	 * Constructor Task.
	 * @param name It is String.
	 * @param description It is String.
	 * @param create It is long.
	 */
    public Task(String name, String description, long create) {
        super(name, description, create);
    }
}
