package ma.ensa.ormjpaspringboot.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import java.util.Date;
@Entity //for mapping ORM
@Data @NoArgsConstructor @AllArgsConstructor //Lombok Generates setters getters and constructor
public class Patient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 50)
    private String nom;
    @Temporal(TemporalType.DATE)
    private Date  dateNaissace;
    private boolean malade;
    private int score;
}
