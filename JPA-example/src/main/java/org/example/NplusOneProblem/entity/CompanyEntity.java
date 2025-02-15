package org.example.NplusOneProblem.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "company")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompanyEntity {

    @Id
    private Long id;

    @Column(
        name = "name",
        nullable = false,
        columnDefinition = "varchar(100)"
    )
    private String name;

    @OneToMany(
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL,
        mappedBy = "company"
    )
    private List<EmployeeEntity> employees;


}
