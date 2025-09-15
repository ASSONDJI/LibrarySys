package INAF.LybraSys.Bibliothecaire.Domain;

import INAF.LybraSys.User.Domain.UsersModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bibliothecaires")


public class BibliothecaireModel extends UsersModel {

    private String address;
    private String email;
    private String phoneNumber;

}
