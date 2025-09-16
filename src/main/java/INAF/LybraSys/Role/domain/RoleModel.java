package INAF.LybraSys.Role.domain;


import INAF.LybraSys.User.Domain.UsersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "role")
public class RoleModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private long idRole;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "role")
    private List<UsersModel> users;

    public long getIdRole() {
        return idRole;
    }

    public String getName() {
        return name;
    }

    public List<UsersModel> getUsers() {
        return users;
    }

    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsers(List<UsersModel> users) {
        this.users = users;
    }
}
