package priv.backend.entity.dto;

import lombok.Data;

/**
 * Client DTO 客户实体类
 */
@Data
public class Client {
    private Integer id;
    private String code; // 客户编号
    private String name; // 客户名称
    private String address; // 客户地址
    private String telephone; // 客户电话
    private String email; // 客户邮箱

}