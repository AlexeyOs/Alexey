package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class OccupiedWayException extends RuntimeException {
    /**
     * @param msg - message.
     */
    public OccupiedWayException(String msg) {
        super(msg);
    }
}
