package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class ImposibleMoveException extends RuntimeException {
    /**
     * @param msg - message.
     */
    public ImposibleMoveException(String msg) {
        super(msg);
    }
}
