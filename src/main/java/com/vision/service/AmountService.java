package com.vision.service;

import static com.vision.util.GlobalConstants.APP_CODE;
import static com.vision.util.GlobalConstants.SEARCH_TEXT;
import static com.vision.util.GlobalConstants.USERNAME;
import static com.vision.util.GlobalConstants.PERSON_NAME;
import static com.vision.util.GlobalConstants.IDS;
import static com.vision.util.GlobalConstants.FROM_DATE;
import static com.vision.util.GlobalConstants.TO_DATE;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vision.model.AmountModel;
import com.vision.repository.IAmountDao;
import com.vision.util.ServiceUtil;
import com.vision.viewmodel.MasterViewModel;

@Service
public class AmountService implements IAmountService {

	@Autowired
	private ServiceUtil serviceUtil;

	@Autowired
	private IAmountDao amountDao;

	@Override
	public Map<String, Object> getAmount(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<AmountModel> list = amountDao.findAll();

			if (list != null && list.size() > 0) {
				serviceUtil.addResponseDataForSuccess(list, "Fetch Successful.");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> getAmountByIds(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, IDS)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<UUID> ids = Arrays.asList(viewModel.getIds()).stream().map(UUID::fromString)
					.collect(Collectors.toList());

			List<AmountModel> list = amountDao.findByIdIn(ids);

			if (list != null && list.size() > 0) {
				serviceUtil.addResponseDataForSuccess(list, "Fetch Successful.");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> addAmount(AmountModel model, MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			AmountModel savedModel = amountDao.save(model);
			serviceUtil.addResponseDataForSuccess(savedModel, "Save Successful");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> addAllAmount(List<AmountModel> models, MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<AmountModel> savedModels = amountDao.saveAll(models);
			serviceUtil.addResponseDataForSuccess(savedModels, "Save Successful");

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> searchAmount(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, SEARCH_TEXT)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = amountDao.getAmountIdsBySearchText(viewModel.getSearchText().toLowerCase().trim());

			if (idsObj != null && idsObj.length > 0) {

				List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
						.collect(Collectors.toList());

				List<AmountModel> list = amountDao.findByIdIn(ids);

				serviceUtil.addResponseDataForSuccess(list, "Deleted Successfully");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> deleteAmountByIds(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, IDS)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {

			List<UUID> ids = Arrays.asList(viewModel.getIds()).stream().map(UUID::fromString)
					.collect(Collectors.toList());

			int count = amountDao.deleteByIdIn(ids);

			if (count > 0) {
				serviceUtil.addResponseDataForSuccess(count, "Deleted Successfully");
			} else {
				serviceUtil.addResponseDataForSuccess("No data deleted.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> searchAmountByName(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, SEARCH_TEXT)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = amountDao.getAmountIdsByName(viewModel.getSearchText().toLowerCase().trim());

			if (idsObj != null && idsObj.length > 0) {

				List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
						.collect(Collectors.toList());

				List<AmountModel> list = amountDao.findByIdIn(ids);

				serviceUtil.addResponseDataForSuccess(list, "Deleted Successfully");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> searchAmountByStatus(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, SEARCH_TEXT)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = amountDao.getAmountIdsByStatus(viewModel.getSearchText().toLowerCase().trim());

			if (idsObj != null && idsObj.length > 0) {

				List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
						.collect(Collectors.toList());

				List<AmountModel> list = amountDao.findByIdIn(ids);

				serviceUtil.addResponseDataForSuccess(list, "Deleted Successfully");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> searchAmountByDate(MasterViewModel viewModel) {

		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, FROM_DATE, TO_DATE)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = amountDao.getAmountIdsByDate(viewModel.getFromDate(), viewModel.getToDate());

			if (idsObj != null && idsObj.length > 0) {

				List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
						.collect(Collectors.toList());

				List<AmountModel> list = amountDao.findByIdIn(ids);

				serviceUtil.addResponseDataForSuccess(list, "Deleted Successfully");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

	@Override
	public Map<String, Object> searchAmountByDatePersonName(MasterViewModel viewModel) {
		if (serviceUtil.isFailedPrecoditions(viewModel, APP_CODE, USERNAME, FROM_DATE, TO_DATE, PERSON_NAME)) {
			return serviceUtil.getServiceReturnForPreconditionFailed();
		}

		try {
			Object[] idsObj = amountDao.searchAmountByDatePersonName(viewModel.getFromDate(), viewModel.getToDate(),
					viewModel.getPersonName().toLowerCase().trim());

			if (idsObj != null && idsObj.length > 0) {

				List<UUID> ids = Arrays.asList(idsObj).stream().map(idObj -> UUID.fromString((String) idObj))
						.collect(Collectors.toList());

				List<AmountModel> list = amountDao.findByIdIn(ids);

				serviceUtil.addResponseDataForSuccess(list, "Deleted Successfully");
			} else {
				serviceUtil.addResponseDataForSuccess("No such found.");
			}

		} catch (Exception e) {
			serviceUtil.addResponseDataForException(e);
		}

		return serviceUtil.getServiceReturn();
	}

}
