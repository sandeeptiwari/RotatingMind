package com.rotatingmind.in_memory_mysql.sqlCommand;

import com.rotatingmind.in_memory_mysql.data.Column;
import com.rotatingmind.in_memory_mysql.data.Database;
import com.rotatingmind.in_memory_mysql.data.Table;

import java.util.Set;

public class CreateTableCommand implements SQLCommand {

    private final String tableName;
    private final Set<Column> columns;

    public CreateTableCommand(String tableName, Set<Column> columns) {
        this.tableName = tableName;
        this.columns = columns;
    }

    @Override
    public void execute() {
        Table table = new Table(tableName, columns);
        Database.getInstance().putTable(tableName, table);
        System.out.println("Successfully created table");
    }
}
