package com.rotatingmind.json_parser;

public interface JsonParser {

    Json parse(String jsonToken);

    String toString(Json json);


}
