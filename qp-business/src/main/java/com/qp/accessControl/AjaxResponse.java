package com.qp.accessControl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AjaxResponse<T> {
    private int status;
    private String message;
    private T data;
    private Map<String, Object> metadata;

    // 构造函数
    public static <T> AjaxResponse<T> success(T data) {
        int status = 200;
        String message = "Success";
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");

        return new AjaxResponse<>(status, message, data, metadata);
    }

    public static <T> AjaxResponse<T> error(String message) {
        int status = 500;
        T data = (T) message;
        Map<String, Object> metadata = new HashMap<>();
        metadata.put("key", "value");

        return new AjaxResponse<>(status, "Error", data, metadata);
    }
}