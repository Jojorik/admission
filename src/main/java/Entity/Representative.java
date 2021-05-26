package Entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "representative")
public class Representative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private int phoneNumber;

    private String registration;

    private String gender;

    private String citizenship;

    private String parent;

    private String trustee;
}
