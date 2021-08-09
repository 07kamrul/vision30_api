package com.vision.repository;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.vision.model.NoticeModel;

@Repository
@Transactional
public interface INoticeDao extends JpaRepository<NoticeModel,UUID> {

	int deleteByIdIn(List<UUID> ids);

	List<NoticeModel> findByIdIn(List<UUID> ids);

	@Query(value = "SELECT CAST (id as character varying) " 
		+ " FROM notice WHERE "
		, nativeQuery = true)
	Object[] getNoticeIdsBySearchText(@Param("searchText") String searchText);

}
