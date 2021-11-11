/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tricky5inarow;

/**
 *
 * @author BISOLA-OJO
 */
public class Collect {
    private boolean truthval;
    private int row;
    private int column;

    public Collect(boolean truthval, int row, int column) {
        this.truthval = truthval;
        this.row = row;
        this.column = column;
    }

    public boolean isTruthval() {
        return truthval;
    }

    public void setTruthval(boolean truthval) {
        this.truthval = truthval;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }
}
