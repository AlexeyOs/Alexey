package ru.osetsky.chess;

/**
 * Created by koldy on 01.07.2017.
 */
public class Cell {
    /**
     * field describes axis X.
     */
    private int axisX;
    /**
     * field describes axis Y.
     */
    private int axisY;

    /**
     * constructor of class.
     *
     * @param axisX axis X.
     * @param axisY axis Y.
     */
    public Cell(int axisX, int axisY) {
        this.axisX = axisX;
        this.axisY = axisY;
    }

    /**
     * set axis X.
     *
     * @param axisX X.
     */
    public void setAxisX(int axisX) {
        this.axisX = axisX;
    }

    /**
     * set axis Y.
     *
     * @param axisY Y.
     */
    public void setAxisY(int axisY) {
        this.axisY = axisY;
    }
    /**
     * get axis X.
     *
     * @return X.
     */
    public int getAxisX() {
        return axisX;
    }

    /**
     * get axis Y.
     *
     * @return Y.
     */
    public int getAxisY() {
        return axisY;
    }

    /**
     * method for comparing the cell field.
     *
     * @param o object whose need to compare.
     * @return true if object is equelse.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cell)) {
            return false;
        }

        Cell cell = (Cell) o;

        if (axisX != cell.axisX) {
            return false;
        }
        return axisY == cell.axisY;

    }

    @Override
    public int hashCode() {
        int result = axisX;
        result = 31 * result + axisY;
        return result;
    }

}
