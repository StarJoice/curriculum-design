package priv.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import priv.backend.entity.PageBean;
import priv.backend.entity.RestBean;
import priv.backend.entity.dto.User;
import priv.backend.service.UserService;
import priv.backend.utils.ReturnUtils;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // 新增用户
    @PostMapping("/add")
    public RestBean<Void> add(@RequestBody User user) { // 不返回数据，只返回结果
        return ReturnUtils.message(userService::addUser, user); // 请求携带数据，只携带处理结果，不携带数据返回的
    }

    // 查询所有用户
    @GetMapping("/list")
    public RestBean<Object> getAllUser(PageBean pageBean) { // 需要返回数据
        return ReturnUtils.messageData(userService::getAllUser, pageBean); //请求携带分页参数，响应请求需要携带数据返回的
    }

    // message方法：返回值(String == 消息) 为空代表请求成功， 不为空则代表请求失败，返回失败消息
    // messageData方法：返回值(Object == 数据) 不为空则代表请求成功，返回数据，为空则代表请求失败
    // 根据id查询用户
    @GetMapping("/{id}")
    public RestBean<Object> getUserById(@PathVariable("id") Integer id) { // 需要返回数据
//        return ReturnUtils.messageData(userService::getUserById, id) ;
        // 或者 哪个顺眼用哪个
        return ReturnUtils.messageData(() -> userService.getUserById(id));
    }

    @PostMapping("/login")
    public RestBean<Object> login(@RequestBody Map<String, String> requestBody) {
        String username = requestBody.get("username");
        String password = requestBody.get("password");
        return ReturnUtils.messageData(() -> userService.login(username, password));
    }

}
