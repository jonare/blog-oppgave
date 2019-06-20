

package ludvigsen.blog.database;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * We save some statistics on external links, done from {@link ludvigsen.blog.controller.RedirectController}
 */
public class ClickStats {

    private static final Map<String, Integer> clicks = Collections.synchronizedMap(new HashMap<String, Integer>());

    public static void addClick(String url) {
        int count = 0;
        if (clicks.containsKey(url)) {
            count = clicks.get(url);
        }
        clicks.put(url, count + 1);
    }
}
