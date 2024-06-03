package priv.backend.service.Impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.User;
import priv.backend.mapper.UserMapper;
import priv.backend.service.UserService;
import priv.backend.utils.PasswordUtils;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper mapper;

    @Autowired
    public UserServiceImpl(UserMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public String addUser(User user) {
        if (user == null) {
            return "必填项为空";
        }
        // 对密码进行MD5加密
        String hashedPassword = PasswordUtils.generateMD5Hash(user.getPassword());
        user.setPassword(hashedPassword);


        if (!this.save(user)) {
            return "添加失败";
        }

        // 业务结束，添加成功
        return null;
    }

    @Override
    public Object getAllUser(PageBean pageBean) {
        // 分页
        if (pageBean.getIsItPaginated()) {
            Page<User> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
            // 查询所有
            return mapper.selectPage(page, new QueryWrapper<>());
        }
        // 不分页
        return this.list();
    }


    @Override
    public Object getUserById(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        // 查询用户并返回
        return mapper.selectById(id);
    }

    @Override
    public User login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);

        User user = mapper.selectOne(queryWrapper);

        if (user != null && PasswordUtils.verifyPassword(password, user.getPassword())) {
            return user;
        }
        return null;
    }


}
