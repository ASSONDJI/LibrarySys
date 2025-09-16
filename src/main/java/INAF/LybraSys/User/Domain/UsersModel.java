package INAF.LybraSys.User.Domain;

import INAF.LybraSys.Emprunt.domain.EmpruntModel;
import INAF.LybraSys.Role.domain.RoleModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;


import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Users")

public class UsersModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUser;
    private String name;
    private String firstname;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id")
    private RoleModel role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmpruntModel> emprunts;

    public long getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public RoleModel getRole() {
        return role;
    }

    public List<EmpruntModel> getEmprunts() {
        return emprunts;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setRole(RoleModel role) {
        this.role = role;
    }

    public void setEmprunts(List<EmpruntModel> emprunts) {
        this.emprunts = emprunts;
    }
}
