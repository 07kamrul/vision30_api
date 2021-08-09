package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.UsersModel;

@Repository
@Transactional
public interface IUsersDao extends JpaRepository<UsersModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<UsersModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM users WHERE "
		, nativeQuery = true)
	Object[] getUsersIdsBySearchText(@Param("searchText") String searchText);

}
