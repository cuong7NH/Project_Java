package src.model;

public class Cadre {
    protected String id;
    protected String name;
    protected Integer age;
    protected Integer gender;
    protected String address;
    protected String phone;
    protected Integer coefficientsSalary;
    protected Integer work_day;
    protected Integer homeTownId;

    public Cadre(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficientsSalary, Integer work_day, Integer homeTownId) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.coefficientsSalary = coefficientsSalary;
        this.work_day = work_day;
        this.homeTownId = homeTownId;
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
        return coefficientsSalary;
    }

    public void setCoefficientsSalary(Integer coefficientsSalary) {
        this.coefficientsSalary = coefficientsSalary;
    }

    public Integer getWorkDay() {
        return work_day;
    }

    public void setWorkDay(Integer work_day) {
        this.work_day = work_day;
    }

    public Integer getHomeTownId() {
        return homeTownId;
    }

    public void setHomeTownId(Integer homeTownId) {
        this.homeTownId = homeTownId;
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
                ", coefficientsSalary=" + coefficientsSalary +
                ", work_day=" + work_day +
                ", homeTownId=" + homeTownId +
                '}';
    }
}
