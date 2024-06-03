package priv.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.StockIn;

public interface StockInService extends IService<StockIn> {
    /**
     * 查询所有入库单
     *
     * @param pageBean 分页参数
     * @return 分页数据
     */
    Object getAllStockIn(PageBean pageBean);

    /**
     * 根据id查询入库单
     *
     * @param id 入库单id
     * @return 入库单信息
     */
    Object getStockInById(Integer id);

    /**
     * 添加入库单
     *
     * @param stockIn 入库单信息
     * @return 是否成功
     */
    String addStockIn(StockIn stockIn);

    /**
     * 修改入库单
     *
     * @param stockIn 入库单信息
     * @return 是否成功
     */
    String updateStockIn(StockIn stockIn);

    /**
     * 删除入库单
     *
     * @param id 入库单id
     * @return 是否成功
     */
    String deleteStockIn(Integer id);

    /**
     * 查询入库单
     *
     * @param stockIn 查询条件
     * @return 入库单信息
     */
    Object queryStockIn(StockIn stockIn);
}
