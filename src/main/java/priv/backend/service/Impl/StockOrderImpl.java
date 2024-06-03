package priv.backend.service.Impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.StockOrder;
import priv.backend.mapper.StockOrderMapper;
import priv.backend.service.StockOrderService;

@Service
public class StockOrderImpl extends ServiceImpl<StockOrderMapper, StockOrder> implements StockOrderService {
    private final StockOrderMapper mapper;

    @Autowired
    public StockOrderImpl(StockOrderMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getStockOrderById(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        return mapper.selectById(id);
    }

    @Override
    public Object getAllStockOrder(PageBean pageBean) {
        // 分页
        if (pageBean.getIsItPaginated()) {
            Page<StockOrder> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
            // 查询所有
            return mapper.getAllStockOrder(page);
        }
        // 不分页
        return this.list();

    }

    @Override
    public String addStockOrder(StockOrder stockOrder) {
        if (stockOrder == null) {
            return "必填项为空";
        }
        if (!this.save(stockOrder)) {
            return "新增失败";
        }

        return null;
    }

    @Override
    public String updateStockOrder(StockOrder stockOrder) {
        if (stockOrder == null) {
            return "必填项为空";
        }
        if (!this.updateById(stockOrder)) {
            return "更新失败";
        }
        return null;
    }

    @Override
    public String deleteStockOrder(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        if (!this.removeById(id)) {
            return "删除失败";
        }
        return null;
    }

    @Override
    public Object queryStockOrder(StockOrder stockOrder) {
        if (stockOrder.getOrderTime() == null || stockOrder.getOrderTime().isEmpty()) {
            stockOrder.setOrderTime(null);
        }
        if (stockOrder.getCode() == null || stockOrder.getCode().isEmpty()) {
            stockOrder.setCode(null);
        }
        return mapper.queryStockOrder(stockOrder);
    }

}

