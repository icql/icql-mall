package work.icql.icm.product.b.server.designpattern.structural.composite;

import work.icql.java.designpattern.structural.composite.human.Department;
import work.icql.java.designpattern.structural.composite.human.Employee;
import work.icql.java.designpattern.structural.composite.human.repository.DepartmentRepo;
import work.icql.java.designpattern.structural.composite.human.repository.EmployeeRepo;

import java.util.List;

public class CompositeHumanResourceClient {

    private static final long ORGANIZATION_ROOT_ID = 1001;
    // 依赖注入
    private DepartmentRepo departmentRepo;
    // 依赖注入
    private EmployeeRepo employeeRepo;

    public void buildOrganization() {
        Department rootDepartment = new Department(ORGANIZATION_ROOT_ID);
        buildOrganization(rootDepartment);
    }

    private void buildOrganization(Department department) {
        List<Long> subDepartmentIds = departmentRepo.getSubDepartmentIds(department.getId());
        for (Long subDepartmentId : subDepartmentIds) {
            Department subDepartment = new Department(subDepartmentId);
            department.addSubNode(subDepartment);
            buildOrganization(subDepartment);
        }
        List<Long> employeeIds = employeeRepo.getDepartmentEmployeeIds(department.getId());
        for (Long employeeId : employeeIds) {
            //这里不应该循环里边调用
            double salary = employeeRepo.getEmployeeSalary(employeeId);
            department.addSubNode(new Employee(employeeId, salary));
        }
    }
}
