package src.model;

public class Cadre {
    protected String id;
    protected String name;
    protected Integer age;
    protected Integer gender;
    protected String address;
    protected String phone;
    protected Integer coefficients_salary;
    protected Integer work_day;
    protected Integer home_town_id;

    public Cadre(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficients_salary, Integer work_day, Integer home_town_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.coefficients_salary = coefficients_salary;
        this.work_day = work_day;
        this.home_town_id = home_town_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCoefficientsSalary() {
        return coefficients_salary;
    }

    public void setCoefficientsSalary(Integer coefficients_salary) {
        this.coefficients_salary = coefficients_salary;
    }

    public Integer getWorkDay() {
        return work_day;
    }

    public void setWorkDay(Integer work_day) {
        this.work_day = work_day;
    }

    public Integer getHomeTownId() {
        return home_town_id;
    }

    public void setHomeTownId(Integer home_town_id) {
        this.home_town_id = home_town_id;
    }

    @Override
    public String toString() {
        return "Cadre{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", coefficients_salary=" + coefficients_salary +
                ", work_day=" + work_day +
                ", home_town_id=" + home_town_id +
                '}';
    }
}
