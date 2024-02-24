package com.rotatingmind.in_memory_mysql.filter;

import com.rotatingmind.in_memory_mysql.data.Column;
import com.rotatingmind.in_memory_mysql.data.Row;
import com.rotatingmind.in_memory_mysql.data.Table;
import com.rotatingmind.in_memory_mysql.operator.Operator;

public class BaseFilter implements Filter {

    private final Column column;
    private final Operator operator;
    private final String expectedVal;

    public BaseFilter(Column column, Operator operator, String expectedVal) {
        this.column = column;
        this.operator = operator;
        this.expectedVal = expectedVal;
    }

    @Override
    public Table filter(Table table) {
        Table filteredTable = new Table("Temp", table.getColumns());
        for (Row row : table.getRows()) {
            if (operator.operate(row.get(column), expectedVal))
                filteredTable.addRow(row);
        }
        return filteredTable;
    }
}