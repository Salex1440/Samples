package org.example.NplusOneProblem.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {

    @Id
    private Long id;

    @Column(
        name = "full_name",
        nullable = false,
        columnDefinition = "varchar(255)"
    )
    private String fullName;

    @ManyToOne
    @JoinColumn(
        name = "company_id",
        columnDefinition = "int8",
        foreignKey = @ForeignKey(name = "fk_employee_company")
    )
    private CompanyEntity company;

}
