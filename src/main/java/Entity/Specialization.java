package Entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "specialization")
public class Specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String form;

    private double score;

}

