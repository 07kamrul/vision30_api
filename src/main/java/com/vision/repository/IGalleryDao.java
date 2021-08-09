package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.GalleryModel;

@Repository
@Transactional
public interface IGalleryDao extends JpaRepository<GalleryModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<GalleryModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM gallery WHERE "
		, nativeQuery = true)
	Object[] getGalleryIdsBySearchText(@Param("searchText") String searchText);

}
