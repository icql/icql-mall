package work.icql.icm.product.b.server.doc.code.designpattern.structural.composite.human;

public class Employee extends HumanResource {

    public Employee(long id, double salary) {
        super(id);
        this.salary = salary;
    }

    @Override
    public double calculateSalary() {
        return salary;
    }
}
