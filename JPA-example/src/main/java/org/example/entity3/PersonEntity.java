package org.example.entity3;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.jpa.repository.EntityGraph;

@Entity
@Table(name = "person")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@NamedEntityGraph(name = "person-with-address", attributeNodes = { @NamedAttributeNode(value = "address")})
public class PersonEntity {

    @Id
    @Column(
        name = "id",
        columnDefinition = "int8"
    )
    private Long id;

    @Column(
        name = "name",
        columnDefinition = "varchar(255)",
        nullable = false
    )
    private String name;

    @ManyToOne(
        fetch = FetchType.LAZY
    )
    @JoinColumn(
        name = "address_id",
        columnDefinition = "int8",
        foreignKey = @ForeignKey(name = "person_address_fk")
    )
    private AddressEntity address;

}
