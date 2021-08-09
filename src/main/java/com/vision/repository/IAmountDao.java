package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.AmountModel;

@Repository
@Transactional
public interface IAmountDao extends JpaRepository<AmountModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<AmountModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM amount WHERE "
		+ " LOWER(person_name) LIKE %:searchText% "
		, nativeQuery = true)
	Object[] getAmountIdsBySearchText(@Param("searchText") String searchText);

}
