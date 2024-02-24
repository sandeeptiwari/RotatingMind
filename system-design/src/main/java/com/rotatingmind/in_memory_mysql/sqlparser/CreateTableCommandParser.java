package com.rotatingmind.in_memory_mysql.sqlparser;



import com.rotatingmind.in_memory_mysql.sqlCommand.CreateTableCommand;
import com.rotatingmind.in_memory_mysql.sqlCommand.SQLCommand;

import java.util.HashSet;

public class CreateTableCommandParser implements SQLCommandParser{
    @Override
    public SQLCommand parse(String query) {
        return new CreateTableCommand("", new HashSet<>());
    }
}
