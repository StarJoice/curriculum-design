package priv.backend.entity.vo.response;

import lombok.Data;

@Data
public class RespStockOrderVO {
    private Integer id;
    private String code;
    private RespClientVO client;
    private RespMerchandiseVO merchandise;
    private Integer orderedQuantity;
    private String orderTime;
    private RespEmployeeVO employee;
}
