package INAF.LybraSys.Student.Domain;


import INAF.LybraSys.Emprunt.domain.EmpruntModel;
import INAF.LybraSys.User.Domain.UsersModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "student")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int idStudent;

    @Column(name = "NAME")
    private String name;

    @Column(name = "FIRSTNAME")
    private String firstname;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PHONENUMBER")
    private String phoneNumber;

    @Column(name = "MAJOR")
    private String major;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "FACULTY")
    private String faculty;


    @ManyToOne
    @JoinColumn(name = "user_id")
    private UsersModel user;


    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<EmpruntModel> emprunts;

}
