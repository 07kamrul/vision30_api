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

import com.vision.model.AboutUsModel;
import com.vision.repository.IAboutUsDao;
import com.vision.util.ServiceUtil;
import com.vision.viewmodel.MasterViewModel;

@Service
public class AboutUsService implements IAboutUsService {

	@Autowired
	private ServiceUtil serviceUtil;

	@Autowired
	private IAboutUsDao aboutUsDao;

	/*
	 * { "apiKey" : "ZWR1Y2l0aW9uQkRBMTIzNDU2Nzg5", "appCode" : "SHOUT", "agencyIds"
	 * : "["47ae9247-dbc6-4cdd-be06-7eb923999b88"]", "username" : "ruhul1234" }
	 */

	@Override
	public Map<String, Object> getAboutUs(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<AboutUsModel> list = aboutUsDao.findAll();
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
	public Map<String, Object> getAboutUsByIds(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<UUID> ids = Arrays.asList(viewModel.getIds()).stream().map(UUID::fromString)
					.collect(Collectors.toList());
			List<AboutUsModel> list = aboutUsDao.findByIdIn(ids);
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
	public Map<String, Object> addAboutUs(AboutUsModel model, MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			AboutUsModel savedModel = aboutUsDao.save(model);
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
	public Map<String, Object> addAllAboutUs(List<AboutUsModel> models, MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<AboutUsModel> savedModels = aboutUsDao.saveAll(models);
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
	public Map<String, Object> searchAboutUs(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, SEARCH_TEXT)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = aboutUsDao.getAboutUsIdsBySearchText(viewModel.getSearchText());
			List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
					.collect(Collectors.toList());
			List<AboutUsModel> list = aboutUsDao.findByIdIn(ids);
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
	public Map<String, Object> deleteAboutUsByIds(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<UUID> ids = Arrays.asList(viewModel.getIds()).stream().map(UUID::fromString)
					.collect(Collectors.toList());
			int count = aboutUsDao.deleteByIdIn(ids);
			serviceUtil.addResponseDataForSuccess(count, "Deleted Successfully");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

}
