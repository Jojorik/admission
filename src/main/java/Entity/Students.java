package Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "students")
public class Students {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToOne(fetch = FetchType.EAGER)
    private Specialization specialization;

    @OneToOne(fetch = FetchType.EAGER)
    private Commission commission;
}
