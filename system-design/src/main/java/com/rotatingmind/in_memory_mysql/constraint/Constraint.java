package com.rotatingmind.in_memory_mysql.constraint;

import com.rotatingmind.in_memory_mysql.data.Row;
import com.rotatingmind.in_memory_mysql.data.Table;

public interface Constraint {
    void applyOnInsertRow(Row rowToBeInserted);
    void applyOnUpdateRow(Row rowToBeUpdated);
    void applyOnDeleteRow(Row rowToBeDeleted);
    //...
    ConstraintType getConstraintType();

    boolean isRelated(Table relatedTable);
}
