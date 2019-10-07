package pl.coderslab.domain;

public class Group extends ResultObject<Group> {
    private Long id;
    private String name;

    public Group() {
    }
    @Override
    public Group setValues(String[] row){
        this.setId(Long.valueOf(row[0]));
        this.setName(row[1]);
        return this;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
