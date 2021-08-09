package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.TermsConditionsModel;

@Repository
@Transactional
public interface ITermsConditionsDao extends JpaRepository<TermsConditionsModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<TermsConditionsModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM terms_conditions WHERE "
		, nativeQuery = true)
	Object[] getTermsConditionsIdsBySearchText(@Param("searchText") String searchText);

}
