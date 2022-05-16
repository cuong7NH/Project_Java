package src.model;

public class Guard extends Cadre{
    private Integer workPlaceId;
    public Guard(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficients_salary, Integer work_day, Integer workPlaceId, Integer home_town_id) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.workPlaceId = workPlaceId;
    }

    public Integer getWorkPlaceId() {
        return workPlaceId;
    }

    public void setWorkPlaceId(Integer workPlaceId) {
        this.workPlaceId = workPlaceId;
    }

}
