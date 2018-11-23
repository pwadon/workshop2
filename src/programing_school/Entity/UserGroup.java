package programing_school.Entity;

public class UserGroup {

    private int id;
    private String name;


    @Override
    public String toString() {
        return "user_Group [id=" + id + ", name=" + name + "]";
    }
    public UserGroup() {
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public UserGroup(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }
    public void setName(String title) {
        this.name = title;
    }
}
