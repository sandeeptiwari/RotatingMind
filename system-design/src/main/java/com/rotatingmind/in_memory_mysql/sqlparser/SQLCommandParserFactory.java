package com.rotatingmind.in_memory_mysql.sqlparser;

public class SQLCommandParserFactory {
    private SQLCommandParserFactory(){}

    public static SQLCommandParser getParser(String query) {
        SQLCommandParser parser = null;
        if (query.contains("create"))
            parser = new CreateTableCommandParser();
        // more checks
        return parser;
    }
}
