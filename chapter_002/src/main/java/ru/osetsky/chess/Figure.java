package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public abstract class Figure {
    public final Cell position;
    Figure(Cell position){
        this.position=position;
    }
    public abstract Cell[]way(Cell dist) throws ImposibleMoveException;

}
