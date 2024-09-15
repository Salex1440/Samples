package org.example.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@NoArgsConstructor
public abstract class AB {

    @Id
    @Column(
        name = "id",
        nullable = false,
        columnDefinition = "int8"
    )
    private Long id;

    @OneToOne(
        mappedBy = "ab"
    )
    private TableC tableC;

    public AB(Long id) {
        this.id = id;
    }
}
