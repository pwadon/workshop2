package programing_school.Entity;

public class solution {

    private String created , updated, description;
    private int id, exercise_id, users_id;

    public solution()
    {}

    public solution(String created, String updated, String description, int exercise_id, int users_id){
        this.created = created;
        this.updated = updated;
        this.description = description;
        this.exercise_id = exercise_id;
        this.users_id = users_id;
    }
    public String toString(){
        return "id=" + id +", created=" + created + ", updated=" + updated +", description="+description +", exercise_id="
                +exercise_id +", users_id=" + users_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getCreated() {
        return created;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public String getUpdated() {
        return updated;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setExercise_id(int exercise_id) {
        this.exercise_id = exercise_id;
    }

    public int getExercise_id() {
        return exercise_id;
    }

    public void setUsers_id(int users_id) {
        this.users_id = users_id;
    }

    public int getUsers_id() {
        return users_id;
    }
}
