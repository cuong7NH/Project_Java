package src.model;

public class Worker extends Cadre{
    private Integer level;
    public Worker(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficients_salary, Integer work_day, Integer home_town_id, Integer level) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.level = level;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

}
