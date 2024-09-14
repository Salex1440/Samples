package org.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AB {

    @Id
    @Column(
        name = "id",
        nullable = false,
        columnDefinition = "int8"
    )
    private Long id;

}
