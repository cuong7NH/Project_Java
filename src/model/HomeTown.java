package src.model;

public class HomeTown {
    private Integer id;
    private String name;

    public HomeTown(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HomeTown{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
