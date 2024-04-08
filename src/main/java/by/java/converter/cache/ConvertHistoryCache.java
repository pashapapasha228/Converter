package by.java.converter.cache;

import by.java.converter.model.ConvertHistory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ConvertHistoryCache {

    private static final Map<Long, ConvertHistory> cache = new LinkedHashMap<>(17, 0.75f, true);

    public void put(Long id, ConvertHistory value) {
        cache.put(id, value);
    }

    public ConvertHistory get(Long id) {
        return cache.get(id);
    }

    public void remove(Long id) {
        cache.remove(id);
    }

}
