package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class Bishop extends Figure {
    /**
     * constructor of class.
     *
     * @param position figure position on model.
     */
    public Bishop(Cell position) {
        super(position);
    }

    /**
     * method describes a possible path of movement of the figure.
     * on the chessboard, and checks whether the motion is possible.
     *
     * @param destenation position on model where need to move figure.
     * @return array of cells that figure should go to the designated path.
     * @throws ImposibleMoveException figure do not move that.
     */
    @Override
    public Cell[] way(Cell destenation) throws ImposibleMoveException {
        int posX = position.getAxisX();
        int posY = position.getAxisY();
        int destX = destenation.getAxisX();
        int destY = destenation.getAxisY();
        Cell[] moves;

        // the condition of the correctness of the movement of the figure

        if (Math.abs(posX - destX) == Math.abs(posY - destY)) {
            moves = createPath(destenation);
        } else {
            throw new ImposibleMoveException("BISHOP IMPOSIBLE MOVE");
        }


        return moves;
    }
    /**
     * copy figure in Cell.
     * @param position - position Bishop.
     * @return figure.
     */
    public Figure clone(Cell position) {
        return new Bishop(position);
    }
}