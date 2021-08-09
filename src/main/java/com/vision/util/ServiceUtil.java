package com.vision.util;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vision.model.UsersModel;
import com.vision.viewmodel.MasterViewModel;

@Service
public class ServiceUtil {

	@Autowired
	private CommonServiceModel serviceModal;

	private Map<String, Function<MasterViewModel, Boolean>> map = new HashMap<>();
	public Predicate<String> isStringNotValid;
	public Predicate<String> isStringNull;
	public Predicate<String[]> isStringArrayNotValid;
	public Predicate<Integer> isZero;
	public Predicate<Double> isLatOrLngNotValid;
	public Predicate<Date> isDateNotValid;
	private UsersModel userModel;

	public ServiceUtil() {

		isStringNotValid = (s) -> s == null || s.isEmpty() || s.equalsIgnoreCase("null");
		isStringNull = (s) -> s == null;
		isStringArrayNotValid = (s) -> s == null || s.length == 0;
		isZero = (n) -> n == 0;
		isLatOrLngNotValid = (n) -> n == GlobalConstants.LONG_POSITIVE_VALUE || n == 0.0;
		isDateNotValid = (d) -> d == null;

		generateValidators();
	}

	public UsersModel getUserModel() {
		return userModel;
	}

	public void setUserModel(UsersModel userModel) {
		this.userModel = userModel;
	}

	public void addMessage(String msg) {
		serviceModal.getMessage().add(msg);
	}

	public void addMessage(List<String> msgs) {
		serviceModal.getMessage().addAll(msgs);
	}

	public List<String> getApiResposeMessages(Map<String, Object> data) {
		List<String> messages = new ArrayList();
		if (data != null) {
			messages = (List<String>) data.get(GlobalConstants.MESSAGE);
			System.out.println("messages" + messages);
		}

		return messages;
	}

	public void addApiResponseMessages(Map<String, Object> data) {
		addMessage(getApiResposeMessages(data));
	}

	public UUID getUUID(String idString) {
		UUID id = null;
		if (idString.length() != 36)
			return id;

		try {
			id = UUID.fromString(idString);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return id;
	}

	public boolean isIdValid(String id) {
		return (getUUID(id) != null) ? true : false;
	}

	public boolean addPreconditionMsgIfNeeded(String itemToBeChecked, String message) {
		boolean isMsgAdded = false;
		if (isStringNotValid.test(itemToBeChecked))
			addMessage(message);
		else
			isMsgAdded = false;

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeeded(String itemToBeChecked, Predicate<String> logic, String message) {
		boolean isMsgAdded = true;
		if (logic.test(itemToBeChecked))
			addMessage(message);
		else
			isMsgAdded = false;

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeeded(String[] itemToBeChecked, String message) {
		boolean isMsgAdded = true;
		if (isStringArrayNotValid.test(itemToBeChecked))
			addMessage(message);
		else
			isMsgAdded = false;

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeeded(Double itemToBeChecked, String message) {
		boolean isMsgAdded = true;
		if (isLatOrLngNotValid.test(itemToBeChecked))
			addMessage(message);
		else
			isMsgAdded = false;

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeeded(Integer itemToBeChecked, String message) {
		boolean isMsgAdded = true;

		if (isZero.test(itemToBeChecked))
			addMessage(message);
		else
			isMsgAdded = false;

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeededForId(String[] itemToBeChecked, String message) {
		boolean isMsgAdded = true;
		if (isStringArrayNotValid.test(itemToBeChecked))
			addMessage(message);
		else {
			if (!isIdValid(itemToBeChecked[0]))
				addMessage(message + " : Not an UUID");
			else
				isMsgAdded = false;
		}

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeededForId(String itemToBeChecked, String message) {
		boolean isMsgAdded = true;
		if (isStringNotValid.test(itemToBeChecked))
			addMessage(message);
		else {
			if (!isIdValid(itemToBeChecked))
				addMessage(message + " : Not An UUID");
			else
				isMsgAdded = false;
		}

		return isMsgAdded;
	}

	public boolean addPreconditionMsgIfNeeded(Date itemToBeChecked, String message) {
		boolean isMsgAdded = true;
		if (isDateNotValid.test(itemToBeChecked))
			addMessage(message);
		else
			isMsgAdded = false;

		return isMsgAdded;
	}

	public void addResponseDataForException(Exception e) {
		e.printStackTrace();
		addMessage(e.toString());
		serviceModal.getData().put(GlobalConstants.DATA, new ArrayList<>());
		serviceModal.getData().put(GlobalConstants.MESSAGE, serviceModal.getMessage());
		serviceModal.getData().put(GlobalConstants.RESPONSE_CODE, GlobalConstants.INTERNAL_ERROR);
		serviceModal.getData().put(GlobalConstants.STATUS, GlobalConstants.EXCEPTION);

	}

	public void addResponseDataForSuccess(Object data) {
		serviceModal.getData().put(GlobalConstants.DATA, data);
		serviceModal.getData().put(GlobalConstants.MESSAGE, serviceModal.getMessage());
		serviceModal.getData().put(GlobalConstants.RESPONSE_CODE, GlobalConstants.OK);
		serviceModal.getData().put(GlobalConstants.STATUS, GlobalConstants.SUCCESSFUL);

	}

	public void addResponseDataForSuccess(Object data, String message) {
		addMessage(message);
		addResponseDataForSuccess(data);
	}

	public void addResponseDataForSuccess(String message) {
		addMessage(message);
		addResponseDataForSuccess(new ArrayList<>());
	}

	public int getMessageSize() {
		return serviceModal.getMessage().size();
	}

	public void addResponseDataForFailure(Object data, String msg) {
		addMessage(msg);
		serviceModal.getData().put(GlobalConstants.DATA, data);
		serviceModal.getData().put(GlobalConstants.MESSAGE, serviceModal.getMessage());
		serviceModal.getData().put(GlobalConstants.RESPONSE_CODE, GlobalConstants.INTERNAL_ERROR);
		serviceModal.getData().put(GlobalConstants.STATUS, GlobalConstants.FAILURE);

	}

	public void addResponseDataForFailure(String msg) {
		addMessage(msg);
		addResponseDataForFailure();
	}

	public void addResponseDataForFailure() {
		serviceModal.getData().put(GlobalConstants.DATA, new ArrayList<>());
		serviceModal.getData().put(GlobalConstants.MESSAGE, serviceModal.getMessage());
		serviceModal.getData().put(GlobalConstants.RESPONSE_CODE, GlobalConstants.INTERNAL_ERROR);
		serviceModal.getData().put(GlobalConstants.STATUS, GlobalConstants.FAILURE);

	}

	public void addResponseDataForUnauthorized() {
		serviceModal.getData().put(GlobalConstants.DATA, new ArrayList<>());
		serviceModal.getData().put(GlobalConstants.MESSAGE, serviceModal.getMessage());
		serviceModal.getData().put(GlobalConstants.RESPONSE_CODE, GlobalConstants.UNAUTHORIZED);
		serviceModal.getData().put(GlobalConstants.STATUS, GlobalConstants.FAILURE);
	}

	public void addResponseDataForPreconditionFailed() {
		if (serviceModal.getMessage().size() > 0) { // Precondition failed
			serviceModal.getData().put(GlobalConstants.DATA, new ArrayList<>());
			serviceModal.getData().put(GlobalConstants.MESSAGE, serviceModal.getMessage());
			serviceModal.getData().put(GlobalConstants.RESPONSE_CODE, GlobalConstants.PRECONDITION_FAILED);
			serviceModal.getData().put(GlobalConstants.STATUS, GlobalConstants.FAILURE);
		}
	}

	public void addResponseDataForUnauthorized(String msg) {
		addMessage(msg);
		addResponseDataForUnauthorized();
	}

	public Map<String, Object> getServiceReturnForPreconditionFailed() {
		addResponseDataForPreconditionFailed();
		return getServiceReturn();
	}

	public Map<String, Object> getServiceReturnForPreconditionFailed(String msg) {
		addMessage(msg);
		addResponseDataForPreconditionFailed();
		return getServiceReturn();
	}

	public Map<String, Object> getServiceReturnForUnauthorized(String msg) {
		addResponseDataForUnauthorized(msg);

		return getServiceReturn();
	}

	public Map<String, Object> getServiceReturnForUnauthorized() {
		addResponseDataForUnauthorized();

		return getServiceReturn();
	}

	public Map<String, Object> getServiceReturn() {
		return serviceModal.getData();
	}

	public boolean isFailedPrecoditions(MasterViewModel viewModel, String... conditionsToBeChecked) {
		boolean isFailedPreCoditions = false;

		for (int i = 0; i < conditionsToBeChecked.length; i++) {
			// addPreConditionMsg(viewModel, conditionsToBeChecked[i]);
			Function<MasterViewModel, Boolean> preconditonLogic = map.get(conditionsToBeChecked[i]);
			if (preconditonLogic != null) {
				preconditonLogic.apply(viewModel);
			} else {
				addMessage("Unknown precondition flag found.");
			}
		}

		if (getMessageSize() > 0)
			isFailedPreCoditions = true;

		return isFailedPreCoditions;
	}

	public void generateValidators() {

		System.out.println("***************Generateing Validators For Service Util********************");
		map.put(GlobalConstants.APP_CODE,
				(viewModel) -> addPreconditionMsgIfNeeded(viewModel.getAppCode(), "Invalid App Code"));

		map.put(GlobalConstants.SEARCH_TEXT, (viewModel) -> addPreconditionMsgIfNeeded(viewModel.getSearchText(),
				isStringNull, "Invalid Search Text"));

		map.put(GlobalConstants.USERNAME,
				(viewModel) -> addPreconditionMsgIfNeeded(viewModel.getUsername(), "Invalid username"));

		map.put(GlobalConstants.DATE, (viewModel) -> addPreconditionMsgIfNeeded(viewModel.getDate(), "Invalid date"));

		map.put(GlobalConstants.FROM_DATE,
				(viewModel) -> addPreconditionMsgIfNeeded(viewModel.getFromDate(), "Invalid from date"));

		map.put(GlobalConstants.TO_DATE,
				(viewModel) -> addPreconditionMsgIfNeeded(viewModel.getToDate(), "Invalid to date"));

		map.put(GlobalConstants.APP_CODE,
				(viewModel) -> addPreconditionMsgIfNeeded(viewModel.getAppCode(), "Invalid App Code"));

		map.put(GlobalConstants.COMMENTS,
				(viewModel) -> addPreconditionMsgIfNeeded(((MasterViewModel) viewModel).getComments(),
						"Invalid Comments"));

	}

}
