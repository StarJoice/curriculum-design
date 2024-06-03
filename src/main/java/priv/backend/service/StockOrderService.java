package priv.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.StockOrder;

public interface StockOrderService extends IService<StockOrder> {
    /**
     * 分页查询所有库存订单
     *
     * @param pageBean 分页参数
     * @return 分页结果
     */
    Object getAllStockOrder(PageBean pageBean);

    /**
     * 新增库存订单
     *
     * @param stockOrder 库存订单
     * @return 新增结果
     */
    String addStockOrder(StockOrder stockOrder);

    /**
     * 更新库存订单
     *
     * @param stockOrder 库存订单
     * @return 更新结果
     */
    String updateStockOrder(StockOrder stockOrder);

    /**
     * 删除库存订单
     *
     * @param id 库存订单id
     * @return 删除结果
     */
    String deleteStockOrder(Integer id);

    /**
     * 根据id查询库存订单
     *
     * @param id 库存订单id
     * @return 库存订单
     */
    Object getStockOrderById(Integer id);

    Object queryStockOrder(StockOrder stockOrder);
}
