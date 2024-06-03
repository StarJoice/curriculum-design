package priv.backend.entity;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.JSONWriter;

/**
 * 返回记录类
 */
public record RestBean<T>(int code, String message, T data) {

    /**
     * 请求成功
     *
     * @param data 需要返回的数据
     * @param <T>  任意实体类
     * @return 返回的实体类
     */
    public static <T> RestBean<T> susccess(T data) {
        return new RestBean<>(200, "请求成功", data);
    }

    /**
     * 不返回数据
     */
    public static <T> RestBean<T> susccess() {
        return new RestBean<>(200, "请求成功", null);
    }

    /**
     * 请求失败
     *
     * @param code    状态码
     * @param message 返回的消息
     * @return 处理结果
     */
    public static <T> RestBean<T> failure(int code, String message) {
        return new RestBean<>(code, message, null);
    }

    /**
     * 格式化
     */
    public String asJsonString() {
        return JSONObject.toJSONString(this, JSONWriter.Feature.WriteNulls);
    }
}
