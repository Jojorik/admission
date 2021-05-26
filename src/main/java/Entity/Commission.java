package Entity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "commission")
public class Commission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne(fetch = FetchType.EAGER)

    private Entrant entrant;

    @OneToOne(fetch = FetchType.EAGER)

    private Representative representative;

    private String secretary;

    private boolean enrolled;
}