package org.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "table_c")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableC {

    @Id
    @Column(
        name = "id",
        nullable = false,
        columnDefinition = "int8"
    )
    private Long id;

    @OneToOne(
        cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.REMOVE }
    )
    @JoinColumn(
        name = "ab_id",
        referencedColumnName = "id",
        columnDefinition = "int8",
        foreignKey = @ForeignKey(name = "ab_fk")
    )
    private AB ab;

}
