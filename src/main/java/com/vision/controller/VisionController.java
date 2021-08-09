package com.vision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.vision.service.IVisionService;
import com.vision.util.IControllerUtil;
import com.vision.viewmodel.MasterViewModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.vision.model.VisionModel;

@RestController
public class VisionController {

	@Autowired
	private IControllerUtil controllerUtil;

	@Autowired
	private IVisionService visionService;

	@PostMapping("/get_vision")
	public ResponseEntity<Map<String, Object>> getVision(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = visionService.getVision(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/get_vision_by_ids")
	public ResponseEntity<Map<String, Object>> getVisionByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = visionService.getVisionByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_vision")
	public ResponseEntity<Map<String, Object>> addVision(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody VisionModel model) {

		MasterViewModel viewModel = model.getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = visionService.addVision(model, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_visions")
	public ResponseEntity<Map<String, Object>> addAllVision(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody List<VisionModel> models) {

		MasterViewModel viewModel = models.get(0).getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = visionService.addAllVision(models, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/search_vision")
	public ResponseEntity<Map<String, Object>> searchVision(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = visionService.searchVision(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/delete_vision_by_ids")
	public ResponseEntity<Map<String, Object>> deleteVisionByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = visionService.deleteVisionByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

}
