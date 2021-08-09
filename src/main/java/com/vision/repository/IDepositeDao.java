package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.DepositeModel;

@Repository
@Transactional
public interface IDepositeDao extends JpaRepository<DepositeModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<DepositeModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM deposite WHERE "
		+ " LOWER(person_name) LIKE %:searchText% "
		, nativeQuery = true)
	Object[] getDepositeIdsBySearchText(@Param("searchText") String searchText);

}
