package com.vision.repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.UsersModel;

@Repository
@Transactional
public interface IUsersDao extends JpaRepository<UsersModel, UUID>, PagingAndSortingRepository<UsersModel, UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<UsersModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) FROM users WHERE ", nativeQuery = true)
	Object[] getUsersIdsBySearchText(@Param("searchText") String searchText);

	public Page<UsersModel> findByUsername(String username, Pageable pageable);

	@Override
	public Optional<UsersModel> findById(UUID id);

	public List<UsersModel> findByUsername(String username);

	public List<UsersModel> findByEmail(String email);

	public List<UsersModel> findByMobile(String mobile);

	public List<UsersModel> findByUsernameIn(List<String> username);

	@Query("FROM UsersModel WHERE username=:usernameOrEmail OR email=:usernameOrEmail ")
	public List<UsersModel> getUserByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

	@Query("FROM UsersModel WHERE LOWER(member_id) LIKE %:searchText% OR "
			+ " LOWER(mobile) LIKE %:searchText% OR LOWER(username) LIKE %:searchText% OR "
			+ " LOWER(email) LIKE %:searchText% ORDER BY username, member_id ")
	public List<UsersModel> getUserBySearchText(@Param("searchText") String searchText);


}
