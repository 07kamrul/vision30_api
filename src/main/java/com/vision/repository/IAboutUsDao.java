package com.vision.repository;

import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.AboutUsModel;

@Repository
@Transactional
public interface IAboutUsDao extends JpaRepository<AboutUsModel, UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<AboutUsModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) "
			+ " FROM about_us WHERE LOWER(descriptions) LIKE %:searchText% ", nativeQuery = true)
	Object[] getAboutUsIdsBySearchText(@Param("searchText") String searchText);

}
