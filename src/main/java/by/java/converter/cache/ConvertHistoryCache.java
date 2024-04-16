package by.java.converter.cache;

import by.java.converter.model.ConvertHistory;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class ConvertHistoryCache {
    private static final int MAZ_SIZE = 16;

    private static final Map<Long, ConvertHistory> cache = new LinkedHashMap<>() {
        @Override
        protected boolean removeEldestEntry(final Map.Entry eldest) {
            return size() > ConvertHistoryCache.MAZ_SIZE;
        }
    };

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
