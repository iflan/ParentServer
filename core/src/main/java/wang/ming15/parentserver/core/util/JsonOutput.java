package wang.ming15.parentserver.core.util;

import java.util.HashMap;
import java.util.Map;

import com.alibaba.fastjson.JSON;

/**
 * Created by wanggnim on 2015/7/18.
 */
public class JsonOutput {

    private Map<String, String> map = new HashMap<>();

    public JsonOutput append(String key, int value) {
        map.put(key, value + "");
        return this;
    }

    public JsonOutput append(String key, long value) {
        map.put(key, value + "");
        return this;
    }

    public JsonOutput append(String key, double value) {
        map.put(key, value + "");
        return this;
    }

    public void printConsole() {
        String str = JSON.toJSONString(map, true);
        System.out.println(str);
    }

    public static JsonOutput builder() {
        return new JsonOutput();
    }
}
