package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.TotalCostModel;

@Repository
@Transactional
public interface ITotalCostDao extends JpaRepository<TotalCostModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<TotalCostModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM total_cost WHERE "
		, nativeQuery = true)
	Object[] getTotalCostIdsBySearchText(@Param("searchText") String searchText);

}
