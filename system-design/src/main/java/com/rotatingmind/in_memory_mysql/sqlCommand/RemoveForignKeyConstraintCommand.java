package com.rotatingmind.in_memory_mysql.sqlCommand;

import com.rotatingmind.in_memory_mysql.constraint.ConstraintType;
import com.rotatingmind.in_memory_mysql.data.Database;
import com.rotatingmind.in_memory_mysql.data.Table;

public class RemoveForignKeyConstraintCommand implements SQLCommand{
    private final String parentTable;
    private final String childTable;

    public RemoveForignKeyConstraintCommand(String parentTable, String childTable) {
        this.parentTable = parentTable;
        this.childTable = childTable;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table parent= db.getTable(parentTable);
        Table child = db.getTable(childTable);
        parent.removeConstraint(ConstraintType.CHILD_FOREIGN_KEY, child);
        child.removeConstraint(ConstraintType.PARENT_FOREIGN_KEY, parent);
        System.out.println("foreign key constraint removed");
    }
}