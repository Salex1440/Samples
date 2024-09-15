package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "table_b")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableB extends AB {

    private String propB;

    public TableB(Long id, String propB) {
        super(id);
        this.propB = propB;
    }

}
