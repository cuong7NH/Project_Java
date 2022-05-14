package src.model;

public class Employee {

    private final Integer id;
    private final String name;
    private final String address;
    private final String phoneNumber;
    private final String type;
    private final Integer salaryScale;
    private final Integer departmentId;
    private Employee(EmployeeBuilder employee) {
        this.id = employee.id;
        this.name = employee.name;
        this.address = employee.address;
        this.phoneNumber = employee.phoneNumber;
        this.type = employee.type;
        this.salaryScale = employee.salaryScale;
        this.departmentId = employee.departmentId;
    }
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public String getType() {
        return type;
    }
    public Integer getSalaryScale() {
        return salaryScale;
    }
    public Integer getDepartmentId() {
        return departmentId;
    }
    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
                ", salaryScale=" + salaryScale +
                ", departmentId=" + departmentId +
                '}';
    }

    public static class EmployeeBuilder
    {
        private Integer id;
        private String name;
        private String address;
        private String phoneNumber;
        private String type;
        private Integer salaryScale;
        private Integer departmentId;

        public EmployeeBuilder id(Integer id) {
            this.id = id;
            return this;
        }
        public EmployeeBuilder name(String name) {
            this.name = name;
            return this;
        }
        public EmployeeBuilder address(String address) {
            this.address = address;
            return this;
        }
        public EmployeeBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }
        public EmployeeBuilder type(String type) {
            this.type = type;
            return this;
        }
        public EmployeeBuilder salaryScale(Integer salaryScale) {
            this.salaryScale = salaryScale;
            return this;
        }
        public EmployeeBuilder departmentId(Integer departmentId) {
            this.departmentId = departmentId;
            return this;
        }
        //Return the finally consrcuted User object
        public Employee build() {
            Employee employee =  new Employee(this);
//            validateUserObject(user);
            return employee;
        }
        private void validateUserObject(User user) {
            //Do some basic validations to check
            //if user object does not break any assumption of system
        }
    }
}
