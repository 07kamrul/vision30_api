package com.vision.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import javax.transaction.Transactional;
import com.vision.model.UserRolesModel;
import com.vision.model.UsersModel;

@Repository
@Transactional
public interface IUserRolesDao extends JpaRepository<UserRolesModel, UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<UserRolesModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " + " FROM user_roles WHERE ", nativeQuery = true)
	Object[] getUserRolesIdsBySearchText(@Param("searchText") String searchText);

	List<UserRolesModel> getRoleByUsernameOrEmail(String username);

	@Query("FROM UsersModel WHERE username=:usernameOrEmail OR email=:usernameOrEmail ")
	public List<UsersModel> getUserByUsernameOrEmail(@Param("usernameOrEmail") String usernameOrEmail);

}
