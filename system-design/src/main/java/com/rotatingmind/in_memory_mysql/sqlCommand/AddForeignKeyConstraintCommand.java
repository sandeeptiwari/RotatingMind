package com.rotatingmind.in_memory_mysql.sqlCommand;

import com.rotatingmind.in_memory_mysql.constraint.ChildForeignKeyConstraint;
import com.rotatingmind.in_memory_mysql.constraint.ColumnMapping;
import com.rotatingmind.in_memory_mysql.constraint.ParentForignKeyConstraint;
import com.rotatingmind.in_memory_mysql.data.ColumnNameMapping;
import com.rotatingmind.in_memory_mysql.data.Database;
import com.rotatingmind.in_memory_mysql.data.Table;

import java.util.ArrayList;
import java.util.List;

public class AddForeignKeyConstraintCommand implements SQLCommand {
    private final String parentTable;
    private final String childTable;
    private final List<ColumnNameMapping> colNameMappings;

    public AddForeignKeyConstraintCommand(String parentTable, String childTable,
                                          List<ColumnNameMapping> colNameMappings) {
        this.parentTable = parentTable;
        this.childTable = childTable;
        this.colNameMappings = colNameMappings;
    }

    @Override
    public void execute() {
        Database db = Database.getInstance();
        Table parent = db.getTable(parentTable);
        Table child = db.getTable(childTable);
        List<ColumnMapping> childColMapping = new ArrayList<>();
        List<ColumnMapping> parentColMapping = new ArrayList<>();
        for (ColumnNameMapping columnNameMapping : colNameMappings) {
            ColumnMapping colMappingForChild = new ColumnMapping(
                    child.getColumn(columnNameMapping.getChildColumn()),
                    parent.getColumn(columnNameMapping.getParentColumn())
            );
            childColMapping.add(colMappingForChild);
            ColumnMapping colMappingForParent = new ColumnMapping(
                    parent.getColumn(columnNameMapping.getParentColumn()),
                    child.getColumn(columnNameMapping.getChildColumn())
            );
            parentColMapping.add(colMappingForParent);
        }
        parent.addConstraint(new ChildForeignKeyConstraint(child, parentColMapping));
        child.addConstraint(new ParentForignKeyConstraint(parent, childColMapping));
    }
}
