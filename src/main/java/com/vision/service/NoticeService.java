package com.vision.service;

import static com.vision.util.GlobalConstants.APP_CODE;
import static com.vision.util.GlobalConstants.SEARCH_TEXT;
import static com.vision.util.GlobalConstants.USERNAME;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vision.model.NoticeModel;
import com.vision.repository.INoticeDao;
import com.vision.util.ServiceUtil;
import com.vision.viewmodel.MasterViewModel;

@Service
public class NoticeService implements INoticeService {

	@Autowired
	private ServiceUtil serviceUtil;

	@Autowired
	private INoticeDao noticeDao;

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234" }
	 */

	@Override
	public Map<String, Object> getNotice(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<NoticeModel> list = noticeDao.findAll();
			serviceUtil.addResponseDataForSuccess(list, "Fetch Successful");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234", "ids"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]" }
	 */

	@Override
	public Map<String, Object> getNoticeByIds(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<UUID> ids = Arrays.asList(viewModel.getIds()).stream().map(UUID::fromString)
					.collect(Collectors.toList());
			List<NoticeModel> list = noticeDao.findByIdIn(ids);
			serviceUtil.addResponseDataForSuccess(list, "Fetch Successful");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234" }
	 */

	@Override
	public Map<String, Object> addNotice(NoticeModel model, MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			NoticeModel savedModel = noticeDao.save(model);
			serviceUtil.addResponseDataForSuccess(savedModel, "Save Successful");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234" }
	 */

	@Override
	public Map<String, Object> addAllNotice(List<NoticeModel> models, MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<NoticeModel> savedModels = noticeDao.saveAll(models);
			serviceUtil.addResponseDataForSuccess(savedModels, "Save Successful");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234",
	 * "searchText" : "data" }
	 */

	@Override
	public Map<String, Object> searchNotice(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, SEARCH_TEXT)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = noticeDao.getNoticeIdsBySearchText(viewModel.getSearchText());
			List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
					.collect(Collectors.toList());
			List<NoticeModel> list = noticeDao.findByIdIn(ids);
			serviceUtil.addResponseDataForSuccess(list, "Deleted Successfully");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234", "ids"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]" }
	 */

	@Override
	public Map<String, Object> deleteNoticeByIds(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<UUID> ids = Arrays.asList(viewModel.getIds()).stream().map(UUID::fromString)
					.collect(Collectors.toList());
			int count = noticeDao.deleteByIdIn(ids);
			serviceUtil.addResponseDataForSuccess(count, "Deleted Successfully");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

}
