package org.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "table_b")
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class TableB extends AB {

    public TableB(Long id) {
        super(id);
    }
}
