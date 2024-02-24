package com.rotatingmind.json_parser;

import java.util.List;

public interface Tokenizer {

    List<KeyValuePair> tokenize(String token);
}
