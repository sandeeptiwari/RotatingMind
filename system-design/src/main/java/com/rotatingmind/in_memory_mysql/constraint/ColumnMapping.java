package com.rotatingmind.in_memory_mysql.constraint;

import com.rotatingmind.in_memory_mysql.data.Column;

public class ColumnMapping {
    private final Column foreignTableCol;

    public Column getForeignTableCol() {
        return foreignTableCol;
    }

    public Column getCurrentTableCol() {
        return currentTableCol;
    }

    private final Column currentTableCol;


    public ColumnMapping(Column forignTableCol, Column currentTableCol) {
        this.foreignTableCol = forignTableCol;
        this.currentTableCol = currentTableCol;
    }
}
