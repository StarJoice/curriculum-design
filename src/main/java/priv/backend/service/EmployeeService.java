package priv.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import priv.backend.entity.PageBean;
import priv.backend.entity.dto.Employee;

public interface EmployeeService extends IService<Employee> {
    /**
     * 获取所有员工（分页）
     *
     * @param pageBean 页码，每页显示数量
     * @return 员工列表
     */
    Object getAllEmployees(PageBean pageBean);

    /**
     * 添加员工
     *
     * @param employee 员工对象
     * @return 添加成功返回true，否则返回false
     */
    String addEmployee(Employee employee);

    /**
     * 更新员工信息
     *
     * @param employee 员工对象
     * @return 更新成功返回true，否则返回false
     */
    String updateEmployee(Employee employee);

    /**
     * 删除员工
     *
     * @param employeeId 员工id
     * @return 删除成功返回true，否则返回false
     */
    String deleteEmployee(Integer employeeId);

    /**
     * 通过id 获取员工信息
     *
     * @param employeeId 员工id
     * @return 员工对象
     */
    Object getEmployeeById(Integer employeeId);

    Object getEmployees();

    Object searchEmployee(Employee employee);
}
