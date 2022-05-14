package src.model;

public class GuardShift {

    private String guard_id;
    private Integer shift_id;

    public GuardShift(String guard_id, Integer shift_id) {
        this.guard_id = guard_id;
        this.shift_id = shift_id;
    }

    public String getGuard_id() {
        return guard_id;
    }

    public void setGuard_id(String guard_id) {
        this.guard_id = guard_id;
    }

    public Integer getShift_id() {
        return shift_id;
    }

    public void setShift_id(Integer shift_id) {
        this.shift_id = shift_id;
    }

    @Override
    public String toString() {
        return "GuardShift{" +
                "guard_id='" + guard_id + '\'' +
                ", shift_id=" + shift_id +
                '}';
    }
}
