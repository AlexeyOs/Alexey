package ru.osetsky.tracker;

/**
 * Created by koldy on 23.03.2017.
 */
public class Task extends Item {
	/**
	 * Constructor Task.
	 * @param name It is String.
	 * @param desc It is String.
	 */
    public  Task(String name, String desc) {
    	this.name = name;
    	this.description = desc;
	}
	/**
	 * Method calculatePrice.
	 * @return  100% It is String.
	 */
    public String calculatePrice() {
    	return "100%";
    }
}
