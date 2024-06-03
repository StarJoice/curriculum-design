package priv.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.backend.entity.PageBean;
import priv.backend.entity.RestBean;
import priv.backend.entity.dto.StockOrder;
import priv.backend.service.StockOrderService;
import priv.backend.utils.ReturnUtils;

@RestController
@RequestMapping("/stockOrder")
public class StockOrderController {
    private final StockOrderService stockOrderService;

    @Autowired
    public StockOrderController(StockOrderService stockOrderService) {
        this.stockOrderService = stockOrderService;
    }

    @GetMapping("list")
    public RestBean<Object> getAllStockOrders(PageBean pageBean) {
        return ReturnUtils.messageData(stockOrderService::getAllStockOrder, pageBean);
    }

    @GetMapping("/{id}")
    public RestBean<Object> getStockOrderById(@PathVariable("id") int id) {
        return ReturnUtils.messageData(stockOrderService::getStockOrderById, id);
    }

    @PutMapping("/update")
    public RestBean<Void> updateStockOrder(@RequestBody StockOrder stockOrder) {
        return ReturnUtils.message(stockOrderService::updateStockOrder, stockOrder);
    }

    @DeleteMapping("/delete/{id}")
    public RestBean<Void> deleteStockOrder(@PathVariable("id") int id) {
        return ReturnUtils.message(stockOrderService::deleteStockOrder, id);
    }

    @PostMapping("/add")
    public RestBean<Void> addStockOrder(@RequestBody StockOrder stockOrder) {
        return ReturnUtils.message(stockOrderService::addStockOrder, stockOrder);
    }

    @PostMapping("/search")
    public RestBean<Object> searchStockOrder(@RequestBody StockOrder stockOrder) {
        return ReturnUtils.messageData(stockOrderService::queryStockOrder, stockOrder);
    }
}
