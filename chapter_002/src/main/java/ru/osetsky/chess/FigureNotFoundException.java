package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class FigureNotFoundException extends RuntimeException {
    /**
     * @param msg - message.
     */
    public FigureNotFoundException(String msg) {
        super(msg);
    }
}
