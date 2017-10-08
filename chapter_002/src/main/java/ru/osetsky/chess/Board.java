package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class Board {
    /**
     * figure on the chess model.
     */
    private Figure figure;
    /**
     * figure position in array.
     */
    private int positionFigure = 0;
    /**
     * array of figures.
     */
    private Figure[] figures = new Figure[10];
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

        this.figures[positionFigure++] = figure;
        return figure;
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
        figure = findFigure(sourse);
        boolean result = imposibleMove(distanse);

        try {
            if (figure == null) {
                throw new FigureNotFoundException("FIGURE NOT FOUND");
            } else if (result) {
                throw new OccupiedWayException("IMPOSEBLI MOVE. THE POSITION OCCUPIED ANOTHER FIGURE");
            }
        } catch (FigureNotFoundException ex) {
            ex.printStackTrace();
        }

        // if conditions is true, move figure at destenation.

//        figure.getPosition().setAxisX(distanse.getAxisX());
//        figure.getPosition().setAxisY(distanse.getAxisY());
        figure.clone(distanse);
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
        for (int i = 0; i != positionFigure; i++) {
            if (figures[i].getPosition().equals(sourse) && figures[i] != null) {
                fig = figures[i];
            }
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
        cellMoves = figure.way(distanse);

        for (int i = 0; i != positionFigure; i++) {
            for (int j = 0; j != cellMoves.length; j++) {

                if (!figures[i].equals(figure) && cellMoves[j].equals(figures[i].getPosition())
                        && cellMoves[j] != null && figures[i] != null) {
                    throw new OccupiedWayException("IMPOSEBLI MOVE. THE POSITION OCCUPIED ANOTHER FIGURE");
                } else if (imposibleMoveSize >= size) {
                    throw new ImposibleMoveException("going beyond the dimensions of the chessboard");
                } else if (figures[i].equals(figure) && !cellMoves[cellMoves.length - 1].equals(distanse)
                        && cellMoves[j] != null && figures[i] != null) {
                    throw new ImposibleMoveException("WRONG COLOR OF THE FIGURE");

                }
            }
        }
        return result;
    }

}