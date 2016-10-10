package com.myolnir.repository;

import com.myolnir.model.UserDO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<UserDO, String> {

    @Query("select u from UserDO u where Email = :email")
    UserDO findByEmail(@Param("email") final String email);
}
