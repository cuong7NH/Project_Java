package src.sort;

import src.model.Cadre;

public class SalaryDTO extends Cadre implements Comparable<SalaryDTO>{
    private Integer salary;
    private Integer yearsOfExperience;
    private Integer level;

    public SalaryDTO(
            String id, String name, Integer age,
            Integer gender, String address, String phone,
            Integer coefficients_salary, Integer work_day, Integer home_town_id,
            Integer salary, Integer yearsOfExperience, Integer level
    ) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.salary = salary;
        this.yearsOfExperience = yearsOfExperience;
        this.level = level;
    }

    public Integer getSalary() {
        return salary;
    }
    public Integer getYears_of_experience() {
        return yearsOfExperience;
    }
    public Integer getLevel() {
        return level;
    }


    @Override
    public int compareTo(SalaryDTO o) {
        return getSalary().compareTo(o.getSalary());
    }

    @Override
    public String toString() {
        return "SalaryDTO{" +
                "salary=" + salary +
                '}';
    }
}
