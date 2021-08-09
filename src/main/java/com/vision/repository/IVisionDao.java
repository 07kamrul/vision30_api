package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.VisionModel;

@Repository
@Transactional
public interface IVisionDao extends JpaRepository<VisionModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<VisionModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM vision WHERE "
		, nativeQuery = true)
	Object[] getVisionIdsBySearchText(@Param("searchText") String searchText);

}
