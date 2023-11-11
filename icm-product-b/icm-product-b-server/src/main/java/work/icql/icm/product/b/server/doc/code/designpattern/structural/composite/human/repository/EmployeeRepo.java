package work.icql.icm.product.b.server.doc.code.designpattern.structural.composite.human.repository;

import java.util.List;

public interface EmployeeRepo {

    List<Long> getDepartmentEmployeeIds(long id);

    double getEmployeeSalary(Long employeeId);
}
