package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.UserProfileModel;

@Repository
@Transactional
public interface IUserProfileDao extends JpaRepository<UserProfileModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<UserProfileModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM user_profile WHERE "
		+ " LOWER(first_name) LIKE %:searchText% "
		+ " OR LOWER(last_name) LIKE %:searchText% "
		+ " OR LOWER(full_name) LIKE %:searchText% "
		+ " OR LOWER(father_name) LIKE %:searchText% "
		+ " OR LOWER(mother_name) LIKE %:searchText% "
		+ " OR LOWER(nominee_name) LIKE %:searchText% "
		+ " OR LOWER(nominee_father_name) LIKE %:searchText% "
		+ " OR LOWER(nominee_mother_name) LIKE %:searchText% "
		+ " OR LOWER(bank_name) LIKE %:searchText% "
		, nativeQuery = true)
	Object[] getUserProfileIdsBySearchText(@Param("searchText") String searchText);

}
