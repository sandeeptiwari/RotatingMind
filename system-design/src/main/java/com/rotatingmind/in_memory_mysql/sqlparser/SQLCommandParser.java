package com.rotatingmind.in_memory_mysql.sqlparser;


import com.rotatingmind.in_memory_mysql.sqlCommand.SQLCommand;

public interface SQLCommandParser {
    SQLCommand parse(String query);
}
