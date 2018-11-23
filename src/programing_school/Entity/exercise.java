package programing_school.Entity;

public class exercise {
    private int id;
    private String file, description;


    public exercise(){}

    public exercise(String file, String description){
        this.file = file;
        this.description=description;
    }
    @Override
    public String toString(){
        return "id=" + id + ", file=" + file +", description=" + description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile() {
        return file;
    }
}
