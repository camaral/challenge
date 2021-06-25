import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MapIterativeChallenge {

  public static List<Map<String, String>> transform(
      final List<Map<String, String>> data,
      final String aggregateFieldName,
      final String countFieldName) {

    Map<String, Map<String, String>> aggregation = new TreeMap<>();
    for (Map<String, String> obj : data
    ) {
      String aggregate = obj.get(aggregateFieldName);
      Integer count = Integer.valueOf(obj.get(countFieldName));

      Map<String, String> result = getAggregation(aggregation, aggregate);
      result.put(aggregateFieldName, aggregate);
      int i = Integer.valueOf(result.getOrDefault(countFieldName, "0")) + count;
      result.put(countFieldName, String.valueOf(i));
    }

    return new ArrayList<>(aggregation.values());
  }

  private static Map<String, String> getAggregation(
      Map<String, Map<String, String>> aggregation,
      String aggKey) {
    if (!aggregation.containsKey(aggKey)) {
      aggregation.put(aggKey, new HashMap<>());
    }
    return aggregation.get(aggKey);
  }
}
