package org.yyf.javase.lambda;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class T {
  public static void main(String[] args) {
    Map<String, Long> elapsedMap = new LinkedHashMap<>();
    elapsedMap.put("virtualAssetBo", 1L);
    elapsedMap.put("planPrincipal", 2L);
    elapsedMap.put("loanPrincipal", 3L);
    elapsedMap.put("availableCash", 4L);
    elapsedMap.put("lockedAmountDetailBo", 5L);
    elapsedMap.put("investOnlyCash",6L );
    elapsedMap.put("todayProfit", 7L);
    elapsedMap.put("typicalTotalProfit",8L );
    elapsedMap.put("lastMonthTotalProfit", 9L);

    Set<Map.Entry<String, Long>> entries = elapsedMap.entrySet();
    Stream<Map.Entry<String, Long>> stream = entries.stream();
    Stream<Map.Entry<String, Long>> sortedStream = stream.sorted(Collections.reverseOrder(Map.Entry.comparingByValue()));

    LinkedHashMap<String, Long> result = sortedStream.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        (e1, e2) -> e1, LinkedHashMap::new));

    LinkedHashMap<String, Long> sortedElapsedMap
        = elapsedMap.entrySet()
                    .stream()
                    .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .collect(
                        Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                            (e1, e2) -> e1, LinkedHashMap::new));
  }
}
