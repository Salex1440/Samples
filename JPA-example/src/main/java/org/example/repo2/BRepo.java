package org.example.repo2;

import org.example.entity2.B;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BRepo extends CrudRepository<B, Long> {
}
