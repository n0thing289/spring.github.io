package bean;

import java.util.Date;

/**
 * 测试简单类型
 */
public class SimpleValueType {
    /*
    八种基本八种包装
    public static boolean isSimpleValueType(Class<?> type) {
         return Void.class != type && Void.TYPE != type &&
                (ClassUtils.isPrimitiveOrWrapper(type) ||
                Enum.class.isAssignableFrom(type) ||
                CharSequence.class.isAssignableFrom(type) ||
                Number.class.isAssignableFrom(type) ||
                Date.class.isAssignableFrom(type) ||            java.util.Date是简单类型
                Temporal.class.isAssignableFrom(type) ||        是java8之后提供的时间和时区
                URI.class == type || URL.class == type ||
                Locale.class == type ||                         是语言类
                Class.class == type);
    }
     */
    private Date birth;

    public void setBirth(Date birth) {
        this.birth = birth;
    }
}
