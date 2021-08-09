package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.SliderModel;

@Repository
@Transactional
public interface ISliderDao extends JpaRepository<SliderModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<SliderModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM slider WHERE "
		, nativeQuery = true)
	Object[] getSliderIdsBySearchText(@Param("searchText") String searchText);

}
