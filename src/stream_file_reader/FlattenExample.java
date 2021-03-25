package stream_file_reader;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FlattenExample {

    public static void main(String[] args) {
        Map<String, List<Map<String, Map<String, Map<String, Map<String, String>>>>>> input =
                ImmutableMap.of("A",
                        ImmutableList.of(ImmutableMap.of("2",
                                ImmutableMap.of("3",
                                        ImmutableMap.of("4",
                                                ImmutableMap.of("5", "a"))))));


    }
}
