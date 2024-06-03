package priv.backend.entity.dto;

import lombok.Data;

/**
 * User DTO 用户实体类
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String password;
}
