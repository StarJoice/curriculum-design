package priv.backend.entity.dto;

import lombok.Data;

/**
 * Employee DTO 员工实体类
 */
@Data
public class Employee {
    private Integer id;
    private String code; // 员工编号
    private String name; // 员工姓名
    private String birthday; // 出生日期
    private boolean gender; // 性别(0-女，1-男)
    private String telephone; // 联系电话
    private String email; // 邮箱
}
