package com.vision.repository;

import java.sql.Date;
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
public interface IAmountDao extends JpaRepository<AmountModel, UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<AmountModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " + " FROM amount WHERE "
			+ " LOWER(person_name) LIKE %:searchText% ", nativeQuery = true)
	Object[] getAmountIdsBySearchText(@Param("searchText") String searchText);

	@Query(value = "SELECT CAST (id as character varying) " + " FROM amount WHERE "
			+ " LOWER(person_name) LIKE %:searchText% " + " OR  ", nativeQuery = true)
	Object[] getAmountIdsByName(@Param("searchText") String searchText);

	@Query(value = "SELECT CAST (id as character varying) " + " FROM amount WHERE "
			+ " LOWER(status) LIKE %:searchText% ", nativeQuery = true)
	Object[] getAmountIdsByStatus(@Param("searchText") String searchText);

	@Query(value = "SELECT CAST (id as character varying) FROM amount "
			+ "WHERE amount_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	Object[] getAmountIdsByDate(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate);

	@Query(value = "SELECT CAST (id as character varying) FROM amount "
			+ "WHERE LOWER(person_name) LIKE %:personName% AND amount_date BETWEEN :fromDate AND :toDate", nativeQuery = true)
	Object[] searchAmountByDatePersonName(@Param("fromDate") Date fromDate, @Param("toDate") Date toDate,
			@Param("personName") String personName);

}
