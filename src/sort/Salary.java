package src.sort;

import src.model.Cadre;

public class Salary extends Cadre {
    private Integer salary;
    private Integer years_of_experience;
    private Integer level;

    public Salary(
            String id, String name, Integer age,
            Integer gender, String address, String phone,
            Integer coefficients_salary, Integer work_day, Integer home_town_id,
            Integer salary, Integer years_of_experience, Integer level
    ) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.salary = salary;
        this.years_of_experience = years_of_experience;
        this.level = level;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getYears_of_experience() {
        return years_of_experience;
    }

    public void setYears_of_experience(Integer years_of_experience) {
        this.years_of_experience = years_of_experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }
}
