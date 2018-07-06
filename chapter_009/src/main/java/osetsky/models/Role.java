package osetsky.models;

/**
 * Created by koldy on 29.06.2018.
 */
public class Role {
    private String id;
    private String name;
    private String description;
    private boolean addcontent;
    private boolean updatecontent;
    private boolean seealluser;

    public Role(String id, String name, String description, boolean addcontent, boolean updatecontent, boolean seealluser) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.addcontent = addcontent;
        this.updatecontent = updatecontent;
        this.seealluser = seealluser;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isAddcontent() {
        return addcontent;
    }

    public boolean isUpdatecontent() {
        return updatecontent;
    }

    public boolean isSeealluser() {
        return seealluser;
    }
}
