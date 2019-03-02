package ru.osetsky.models;

import javax.persistence.*;

/**
 * Created by koldy on 29.06.2018.
 */

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "addcontent")
    private boolean addcontent;
    @Column(name = "updatecontent")
    private boolean updatecontent;
    @Column(name = "seealluser")
    private boolean seealluser;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setAddcontent(boolean addcontent) {
        this.addcontent = addcontent;
    }

    public boolean getAddcontent() {
        return addcontent;
    }

    public void setUpdatecontent(boolean updatecontent) {
        this.updatecontent = updatecontent;
    }

    public boolean getUpdatecontent() {
        return updatecontent;
    }

    public void setSeealluser(boolean seealluser) {
        this.seealluser = seealluser;
    }

    public boolean getSeealluser() {
        return seealluser;
    }


}
