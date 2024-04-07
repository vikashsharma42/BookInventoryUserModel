package com.bookstoreUser.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.bookstoreUser.models.User;
import jakarta.transaction.Transactional;

public interface UserRepository extends JpaRepository<User, String>
{
	@Modifying
	@Transactional
	@Query("update User set password=:pass where userid=:uid")
	void updateUserPassword(@Param("pass") String pass,@Param("uid") String uid);

}
