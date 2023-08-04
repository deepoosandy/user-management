package com.user.management.repository;

import com.user.management.model.domain.Authority;
import com.user.management.model.domain.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority,Long> {
}
