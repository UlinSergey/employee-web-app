package pro.sky.employeewebapp.exception;

public class EmployeeNotFoundException extends RuntimeException {
    public EmployeeNotFoundException(){
        super("Сотрудник не найден");
    }
}
