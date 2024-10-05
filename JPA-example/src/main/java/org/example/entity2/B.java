package org.example.entity2;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class B {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(
        name = "c_id",
        columnDefinition = "int8"
    )
    private C c;

}
