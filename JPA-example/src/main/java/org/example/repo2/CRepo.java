package org.example.repo2;

import org.example.entity2.C;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CRepo extends CrudRepository<C, Long> {
}
