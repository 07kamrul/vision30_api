package com.vision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.vision.service.ITermsConditionsService;
import com.vision.util.IControllerUtil;
import com.vision.viewmodel.MasterViewModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.vision.model.TermsConditionsModel;

@RestController
public class TermsConditionsController {

	@Autowired
	private IControllerUtil controllerUtil;

	@Autowired
	private ITermsConditionsService termsConditionsService;

	@PostMapping("/get_terms_condition")
	public ResponseEntity<Map<String, Object>> getTermsCondition(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = termsConditionsService.getTermsCondition(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/get_terms_condition_by_ids")
	public ResponseEntity<Map<String, Object>> getTermsConditionByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = termsConditionsService.getTermsConditionByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_terms_condition")
	public ResponseEntity<Map<String, Object>> addTermsCondition(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody TermsConditionsModel model) {

		MasterViewModel viewModel = model.getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = termsConditionsService.addTermsCondition(model, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_terms_conditions")
	public ResponseEntity<Map<String, Object>> addAllTermsCondition(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody List<TermsConditionsModel> models) {

		MasterViewModel viewModel = models.get(0).getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = termsConditionsService.addAllTermsCondition(models, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/search_terms_condition")
	public ResponseEntity<Map<String, Object>> searchTermsCondition(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = termsConditionsService.searchTermsCondition(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/delete_terms_condition_by_ids")
	public ResponseEntity<Map<String, Object>> deleteTermsConditionByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = termsConditionsService.deleteTermsConditionByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

}
