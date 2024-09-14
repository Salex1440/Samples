package org.example.repo;

import org.example.entity.TableA;
import org.springframework.data.repository.CrudRepository;

public interface TableARepo extends CrudRepository<TableA, Long> {
}
