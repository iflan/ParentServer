package wang.ming15.parentserver.core.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.esotericsoftware.reflectasm.MethodAccess;

/**
 * Created by wanggnim on 2015/9/7.
 */
public class ReflectUtil {

    private static final Map<String, MethodAccess> methodAccesss = new ConcurrentHashMap<>();

    public static Object invoke(Class clazz, Object obj, String methodName, Object ...param) {

        String className = clazz.getCanonicalName();
        MethodAccess methodAccess = methodAccesss.get(className);
        if (methodAccess == null) {
            methodAccess = MethodAccess.get(clazz);
            methodAccesss.put(className, methodAccess);
        }

        return methodAccess.invoke(obj, methodName, param);
    }

}
