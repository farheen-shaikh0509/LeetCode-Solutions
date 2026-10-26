import java.util.HashMap;
import java.util.Map;

public class Codec {
    private Map<String, String> map = new HashMap<>();
    private int id = 0;

    public String encode(String longUrl) {
        if (longUrl == null) {
            return null;
        }
        String shortUrl = "http://tinyurl.com/" + id++;
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        if (shortUrl == null || !map.containsKey(shortUrl)) {
            return null;
        }
        return map.get(shortUrl);
    }
}