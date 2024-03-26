package com.rotatingmind.in_memory_mysql.sqlCommand;

import com.rotatingmind.in_memory_mysql.data.Database;
import com.rotatingmind.in_memory_mysql.data.Row;
import com.rotatingmind.in_memory_mysql.data.Table;
import com.rotatingmind.in_memory_mysql.filter.Filter;

public class DeleteRowsCommand implements SQLCommand {

    private final String tableName;
    private final Filter filter;

    public DeleteRowsCommand(String tableName, Filter filter) {
        this.tableName = tableName;
        this.filter = filter;
    }

    @Override
    public void execute() {
        Table table = Database.getInstance().getTable(tableName);
        Table filteredTable = filter.filter(table);
        for (Row row : filteredTable.getRows())
            table.deleteRow(row);
        System.out.println("Deleted" + filteredTable.getRows().size() + "rows");
    }
}
