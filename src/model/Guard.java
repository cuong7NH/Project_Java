package src.model;

public class Guard extends Cadre{
    private Integer work_place_id;
    public Guard(String id, String name, Integer age, Integer gender, String address, String phone, Integer coefficients_salary, Integer work_day, Integer work_place_id, Integer home_town_id) {
        super(id, name, age, gender, address, phone, coefficients_salary, work_day, home_town_id);
        this.work_place_id = work_place_id;
    }

    public Integer getWorkPlaceId() {
        return work_place_id;
    }

    public void setWorkPlaceId(Integer work_place_id) {
        this.work_place_id = work_place_id;
    }

}
