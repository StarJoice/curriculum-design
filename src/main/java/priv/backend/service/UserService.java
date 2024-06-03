package priv.backend.service;


import com.baomidou.mybatisplus.extension.service.IService;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.User;

public interface UserService extends IService<User> {

    /**
     * 添加用户
     *
     * @param user 用户信息
     * @return 添加成功返回true，否则返回false
     */
    String addUser(User user);

    /**
     * 查询用户
     *
     * @param pageBean 分页参数
     * @return 用户数据
     */
    Object getAllUser(PageBean pageBean);

    /**
     * 根据用户ID查询用户信息
     *
     * @return 用户数据
     */
    Object getUserById(Integer id);

    /*
      用户登录
      @param username 用户名
     * @param password 密码
     * @return 登录成功返回用户信息，否则返回null
     */
    User login(String username, String password);
}

