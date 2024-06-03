package priv.backend.utils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import priv.backend.entity.RestBean;
import java.util.Collection;
import java.util.function.Function;
import java.util.function.Supplier;
public class ReturnUtils {
    /**
     * 只返回本次请求结果
     */
    public static <T> RestBean<Void> message(Supplier<String> action) {
        String message = action.get();
        return message == null ? RestBean.susccess() : RestBean.failure(400, message);
    }
    /**
     * 携带数据，只返回本次请求结果
     */
    public static <T> RestBean<Void> message(Function<T, String> function, T vo) {
        return message(() -> function.apply(vo));
    }
    /**
     * 携带数据，返回本次请求所需数据
     */
    public static <T, D> RestBean<D> messageData(Function<T, D> function, T vo) {
        return messageData(() -> function.apply(vo));
    }
    /**
     * 携带数据，返回本次请求所需数据
     */
    public static <D> RestBean<D> messageData(Supplier<D> action) {
        D data = action.get();
        // 不为空代表处理失败
        if (data instanceof Page<?> page) {
            if (page.getRecords().isEmpty()) {
                return RestBean.failure(400, "没有查询到数据");
            }
        } else if (data instanceof Collection<?> collection) {
            if (collection.isEmpty()) {
                return RestBean.failure(400, "没有查询到数据");
            }
        } else if (data == null) {
            return RestBean.failure(400, "没有查询到数据");
        }
        // 处理成功
        return RestBean.susccess(data);
    }
}
