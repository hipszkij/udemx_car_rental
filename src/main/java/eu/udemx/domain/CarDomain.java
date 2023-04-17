package eu.udemx.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "cars")
@Getter
@Setter
public class CarDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "status", nullable=false, columnDefinition = "BOOLEAN DEFAULT true")
    private Boolean status;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "type", nullable = false, length = 32)
    private String type;

    @Column(name = "description", length = 128)
    private String description;

    @Column(name = "plate", nullable = false, length = 32)
    private String plate;

    @Column(name = "price", nullable=false)
    private Integer price;

    @Column(name = "created_at", nullable=false, columnDefinition = "TIMESTAMP DEFAULT now()")
    private LocalDateTime createdAt;
}
