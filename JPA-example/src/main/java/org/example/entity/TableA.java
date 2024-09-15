package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "table_a")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableA extends AB {

    private String propA;

    public TableA(Long id, String propA) {
        super(id);
        this.propA = propA;
    }
}
