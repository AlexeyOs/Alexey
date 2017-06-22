package ru.osetsky.tracker.start;

/**
 * Created by koldy on 16.06.2017.
 */
public interface UserAction {
	/**
     * Constructor key.
	 * @return integer.
     */
    int key();
	/**
     * Constructor execute.
	 * @param input It is class Input
	 * @param tracker It is class Tracker.
     */
    void execute(Input input, Tracker tracker);
	/**
     * Constructor info is String.
	 * @return String.
     */
    String info();
}
