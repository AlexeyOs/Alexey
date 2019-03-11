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

    @Override
    public boolean equals(Object obj) {
        // checking if both the object references are
        // referring to the same object.
        if(this == obj)
            return true;

        // it checks if the argument is of the
        // type Role by comparing the classes
        // of the passed argument and this object.
        // if(!(obj instanceof Role)) return false; ---> avoid.
        if(obj == null || obj.getClass()!= this.getClass())
            return false;

        // type casting of the argument.
        Role role = (Role) obj;

        // comparing the state of argument with
        // the state of 'this' Object.
        return (role.id.equals(this.id));
    }

    @Override
    public int hashCode()
    {
        // We are returning the Role_id
        // as a hashcode value.
        // we can also return some
        // other calculated value or may
        // be memory address of the
        // Object on which it is invoked.
        // it depends on how you implement
        // hashCode() method.
        int result = Integer.parseInt(this.id);
        result = 31 * result;
        return result;
    }

}
