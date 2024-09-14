package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "table_a")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableA extends AB {

    public TableA(Long id) {
        super(id);
    }
}
