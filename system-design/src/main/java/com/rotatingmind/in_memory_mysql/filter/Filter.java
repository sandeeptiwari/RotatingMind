package com.rotatingmind.in_memory_mysql.filter;

import com.rotatingmind.in_memory_mysql.data.Table;

public interface Filter {
    Table filter(Table table);
}
