package src.model;

public class Engineer extends Cadre {

    private Integer yearsOfExperience;
    public Engineer(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficients_salary, Integer work_day, Integer home_town_id, Integer yearsOfExperience) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.yearsOfExperience = yearsOfExperience;
    }


    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }
}
