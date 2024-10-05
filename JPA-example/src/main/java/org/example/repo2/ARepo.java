package org.example.repo2;

import org.example.entity2.A;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ARepo extends CrudRepository<A, Long> {
}
