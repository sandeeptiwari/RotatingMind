package com.rotatingmind.in_memory_mysql.sqlCommand;

import com.rotatingmind.in_memory_mysql.constraint.ConstraintType;
import com.rotatingmind.in_memory_mysql.data.Database;
import com.rotatingmind.in_memory_mysql.data.Table;

public class DropTableCommand implements SQLCommand {

    private final String tableName;

    public DropTableCommand(String tableName) {
        this.tableName = tableName;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table tableToBeDeleted = db.getTable(tableName);
        if (!tableToBeDeleted.getConstraintsByType(ConstraintType.CHILD_FOREIGN_KEY)
                .isEmpty()) {
            throw new RuntimeException("first delete its children");
        }
        for (Table table : db.getAllTables()) {
            table.removeConstraint(ConstraintType.CHILD_FOREIGN_KEY, tableToBeDeleted);
        }
        db.deleteTable(tableName);
        System.out.println("Dropped table successfully");
    }
}
