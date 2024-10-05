package org.example.repo3;

import org.example.entity3.PersonEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<PersonEntity, Long> {

    @EntityGraph(value = "person-with-address")
    Optional<PersonEntity> findWithAddressById(Long id);

}
