package com.vision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.vision.service.IUsersService;
import com.vision.util.IControllerUtil;
import com.vision.viewmodel.MasterViewModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.vision.model.UsersModel;

@RestController
public class UsersController {

	@Autowired
	private IControllerUtil controllerUtil;

	@Autowired
	private IUsersService usersService;

	@PostMapping("/get_user")
	public ResponseEntity<Map<String, Object>> getUser(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = usersService.getUser(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/get_user_by_ids")
	public ResponseEntity<Map<String, Object>> getUserByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = usersService.getUserByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_user")
	public ResponseEntity<Map<String, Object>> addUser(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody UsersModel model) {

		MasterViewModel viewModel = model.getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = usersService.addUser(model, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_users")
	public ResponseEntity<Map<String, Object>> addAllUser(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody List<UsersModel> models) {

		MasterViewModel viewModel = models.get(0).getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = usersService.addAllUser(models, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/search_user")
	public ResponseEntity<Map<String, Object>> searchUser(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = usersService.searchUser(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/delete_user_by_ids")
	public ResponseEntity<Map<String, Object>> deleteUserByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = usersService.deleteUserByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

}
