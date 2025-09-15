package INAF.LybraSys.adherent.Domain;

import INAF.LybraSys.User.Domain.UsersModel;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "adherents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AdherentModel extends UsersModel {
    private String address;
    private String email;
    private String phoneNumber;
}
