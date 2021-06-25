import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MapChallenge {

    public static List<Map<String, String>> transform(
            final List<Map<String, String>> data,
            final String aggregateFieldName,
            final String countFieldName) {
        Map<String, List<Map<String, String>>> collect = data.stream().collect(Collectors.groupingBy((map) -> map.get(aggregateFieldName)));
        Map<String, String> result = collect.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey,
                (entry) -> {
                    List<Map<String, String>> values = entry.getValue();
                    int sum = values.stream().mapToInt((valueEntry) -> Integer.valueOf(valueEntry.get(countFieldName))).sum();
                    return String.valueOf(sum);

                }));

        return result.entrySet().stream()
                // Putting back the field names to comply with requested interface
                .map((entry) -> Map.of(aggregateFieldName, entry.getKey(), countFieldName, entry.getValue()))
                // Sorting just to simply test assertion with assertIterableEquals(..)
                .sorted(Comparator.comparing(e -> Integer.valueOf(e.get(countFieldName))))
                .collect(Collectors.toList());
    }
}
