package Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "entrant")
public class Entrant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private float score;

    private String name;

    private int passportId;

    private int passportSeries;

    private String registration;

    private String citizenship;

    private String gender;

    @OneToOne(fetch = FetchType.EAGER)
    private Specialization specialization;
}
