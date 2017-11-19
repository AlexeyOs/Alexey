package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class Board {
    /**
     * array of figures.
     */
    private Figure figures;
    /**
     * chess model size.
     */
    private int size = 8;

    /**
     * method add figure on figures array.
     *
     * @param figure that add.
     * @return figure.
     */
    public Figure addFigure(Figure figure) {
        this.figures = figure;
        return figures;
    }

    /**
     * method move figure and conducts inspections.
     *
     * @param sourse   original position figures.
     * @param distanse the position where you want to move the figure.
     * @return is action possible.
     * @throws ImposibleMoveException   it is impossible to move the piece because of incorrect data.
     * @throws OccupiedWayException    in the way of the figures is another figure.
     * @throws FigureNotFoundException figure not found in sourse.
     */
    public boolean move(Cell sourse, Cell distanse) throws OccupiedWayException, FigureNotFoundException, ImposibleMoveException {
        boolean result = imposibleMove(distanse);
        figures = figures.clone(distanse);
        return result;
    }

    /**
     * method find figure in sourse.
     *
     * @param sourse cell boards where the figure set.
     * @return return figure if it is found.
     */
    final Figure findFigure(Cell sourse) {
        Figure fig = null;
            if (figures.getPosition().equals(sourse) && figures != null) {
                fig = figures;
            }
        return fig;
    }

    /**
     * @param distanse the cell which should go figure.
     * @return if checs validate return false.
     * @throws OccupiedWayException    in the way of the figures is another figure.
     * @throws FigureNotFoundException throws exeption, if figure is not found.
     * @throws ImposibleMoveException it is impossible to move the piece because of incorrect data.
     */
    public boolean imposibleMove(Cell distanse) throws OccupiedWayException, FigureNotFoundException, ImposibleMoveException {
        boolean result = false;
        Cell[] cellMoves;
        int imposibleMoveSize = distanse.getAxisX() > distanse.getAxisY() ? distanse.getAxisX() : distanse.getAxisY();
        cellMoves = this.figures.way(distanse);

            for (int j = 0; j != cellMoves.length; j++) {

                if (!figures.equals(figures) && cellMoves[j].equals(figures.getPosition())
                        && cellMoves[j] != null && figures != null) {
                    throw new OccupiedWayException("IMPOSEBLI MOVE. THE POSITION OCCUPIED ANOTHER FIGURE");
                }
                else if (imposibleMoveSize >= size) {
                    throw new ImposibleMoveException("going beyond the dimensions of the chessboard");
                } else if (figures.equals(figures) && !cellMoves[cellMoves.length - 1].equals(distanse)
                        && cellMoves[j] != null && figures != null) {
                    throw new ImposibleMoveException("WRONG COLOR OF THE FIGURE");

                }
        }
        return result;
    }

}