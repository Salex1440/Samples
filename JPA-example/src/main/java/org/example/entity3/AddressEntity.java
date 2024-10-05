package org.example.entity3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AddressEntity {

    @Id
    @Column(
        name = "id",
        columnDefinition = "int8",
        nullable = false
    )
    private Long id;

    @Column(
        name = "city",
        columnDefinition = "varchar(255)",
        nullable = false
    )
    private String city;

    @Column(
        name = "street",
        columnDefinition = "varchar(255)",
        nullable = false
    )
    private String street;

}
