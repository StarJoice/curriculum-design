package priv.backend;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.User;
import priv.backend.mapper.UserMapper;
import priv.backend.service.Impl.StockInServiceImpl;

@SpringBootTest
class BackendApplicationTests {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void getOneUser() {
        User user = userMapper.selectById(1);
    }

    @Resource
    StockInServiceImpl stockInService;

    @Test
    public void testStockInService() {
        System.out.println(stockInService.getAllStockIn(new PageBean()));
    }

}
