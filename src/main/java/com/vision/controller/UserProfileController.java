package com.vision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.vision.service.IUserProfileService;
import com.vision.util.IControllerUtil;
import com.vision.viewmodel.MasterViewModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.vision.model.UserProfileModel;

@RestController
public class UserProfileController {

	@Autowired
	private IControllerUtil controllerUtil;

	@Autowired
	private IUserProfileService userProfileService;

	@PostMapping("/get_user_profile")
	public ResponseEntity<Map<String, Object>> getUserProfile(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = userProfileService.getUserProfile(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/get_user_profile_by_ids")
	public ResponseEntity<Map<String, Object>> getUserProfileByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = userProfileService.getUserProfileByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_user_profile")
	public ResponseEntity<Map<String, Object>> addUserProfile(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody UserProfileModel model) {

		MasterViewModel viewModel = model.getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = userProfileService.addUserProfile(model, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_user_profiles")
	public ResponseEntity<Map<String, Object>> addAllUserProfile(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody List<UserProfileModel> models) {

		MasterViewModel viewModel = models.get(0).getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = userProfileService.addAllUserProfile(models, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/search_user_profile")
	public ResponseEntity<Map<String, Object>> searchUserProfile(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = userProfileService.searchUserProfile(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/delete_user_profile_by_ids")
	public ResponseEntity<Map<String, Object>> deleteUserProfileByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = userProfileService.deleteUserProfileByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

}
