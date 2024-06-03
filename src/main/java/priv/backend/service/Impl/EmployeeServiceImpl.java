package priv.backend.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.Employee;
import priv.backend.mapper.EmployeeMapper;
import priv.backend.service.EmployeeService;

@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {
    private final EmployeeMapper mapper;

    @Autowired
    public EmployeeServiceImpl(EmployeeMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Object getAllEmployees(PageBean pageBean) {
        // 分页
        if (pageBean.getIsItPaginated()) {
            Page<Employee> page = new Page<>(pageBean.getPageNum(), pageBean.getPageSize());
            // 查询所有
            return mapper.selectPage(page, new QueryWrapper<>());
        }
        // 不分页
        return this.list();
    }

    @Override
    public String addEmployee(Employee employee) {
        if (employee == null) {
            return "必填项为空";
        }
        if (!this.save(employee)) {
            return "添加失败";
        }

        // 业务结束，添加成功
        return null;
    }

    @Override
    public String updateEmployee(Employee employee) {
        if (employee == null) {
            return "必填项为空";
        }
        if (!this.updateById(employee)) {

            return "更新失败";
        }
        // 业务结束，更新成功
        return null;
    }

    @Override
    public String deleteEmployee(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        if (!this.removeById(id)) {
            return "删除失败";
        }
        // 业务结束，删除成功
        return null;
    }


    @Override
    public Object getEmployeeById(Integer id) {
        if (id == null) {
            return "必填项为空";
        }
        // 查询员工并返回
        return mapper.selectById(id);
    }


    @Override
    public Object getEmployees() {
        return this.list();
    }

    @Override
    public Object searchEmployee(Employee employee) {
        QueryWrapper<Employee> queryWrapper = new QueryWrapper<>();

        // 只在 code 非空且非空字符串时添加到查询条件中
        if (employee.getCode() != null && !employee.getCode().trim().isEmpty()) {
            queryWrapper.eq("code", employee.getCode().trim());
        }

        // 只在 name 非空且非空字符串时添加到查询条件中
        if (employee.getName() != null && !employee.getName().trim().isEmpty()) {
            queryWrapper.like("name", "%" + employee.getName().trim() + "%");
        }
        return mapper.selectList(queryWrapper);
    }


}
