package src.model;

public class Engineer extends Cadre {

    private Integer years_of_experience;
    public Engineer(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficients_salary, Integer work_day, Integer home_town_id, Integer years_of_experience) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.years_of_experience = years_of_experience;
    }


    public Integer getYearsOfExperience() {
        return years_of_experience;
    }

    public void setYearsOfExperience(Integer years_of_experience) {
        this.years_of_experience = years_of_experience;
    }
}
