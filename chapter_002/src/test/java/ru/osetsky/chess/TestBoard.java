package ru.osetsky.chess;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by koldy on 28.09.2017.
 */
public class TestBoard {
    /**
     * field model creating the bord.
     */
    private Board board;

    /**
     * field bishop.
     */
    private Bishop bishop;

    /**
     * run method before test.
     */
    @Before
    public void beforeTest() {
        this.board = new Board();
        this.bishop = new Bishop(new Cell(5, 5));
    }




    //MOVE THE BISHOP.

    /**
     * Move bishop.
     *
     * @throws OccupiedWayException    if on the way the figure is another figure.
     * @throws FigureNotFoundException If the figures in the said cell does not exist.
     * @throws ImposibleMoveException if it is impossible to pave the way.
     */
    @Test
    public void whenBishopMveThenSheMove() throws OccupiedWayException, FigureNotFoundException, ImposibleMoveException {
        board.addFigure(bishop); //55
        board.move(bishop.getPosition(), new Cell(3, 3));
        board.move(bishop.getPosition(), new Cell(2, 4));
        board.move(bishop.getPosition(), new Cell(4, 6));
        board.move(bishop.getPosition(), new Cell(5, 5));
        assertThat(bishop.getPosition(), is(new Cell(5, 5)));
    }

}