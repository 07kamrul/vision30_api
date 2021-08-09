package com.vision.controller;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

import com.vision.service.ITotalCostService;
import com.vision.util.IControllerUtil;
import com.vision.viewmodel.MasterViewModel;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import com.vision.model.TotalCostModel;

@RestController
public class TotalCostController {

	@Autowired
	private IControllerUtil controllerUtil;

	@Autowired
	private ITotalCostService totalCostService;

	@PostMapping("/get_total_cost")
	public ResponseEntity<Map<String, Object>> getTotalCost(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = totalCostService.getTotalCost(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/get_total_cost_by_ids")
	public ResponseEntity<Map<String, Object>> getTotalCostByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = totalCostService.getTotalCostByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_total_cost")
	public ResponseEntity<Map<String, Object>> addTotalCost(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody TotalCostModel model) {

		MasterViewModel viewModel = model.getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = totalCostService.addTotalCost(model, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/add_total_costs")
	public ResponseEntity<Map<String, Object>> addAllTotalCost(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody List<TotalCostModel> models) {

		MasterViewModel viewModel = models.get(0).getMasterViewModel();
		if (viewModel == null) {
			controllerUtil.buildPreConditionFailedResponseEntity(request, latLng);
			return controllerUtil.getResponseEntity();
		}

		if (latLng != null) {
			Map<String, Object> data = totalCostService.addAllTotalCost(models, viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/search_total_cost")
	public ResponseEntity<Map<String, Object>> searchTotalCost(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = totalCostService.searchTotalCost(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

	@PostMapping("/delete_total_cost_by_ids")
	public ResponseEntity<Map<String, Object>> deleteTotalCostByIds(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody MasterViewModel viewModel) {

		if (latLng != null) {
			Map<String, Object> data = totalCostService.deleteTotalCostByIds(viewModel);
			controllerUtil.buildResponseEntity(data);
		} else {
			controllerUtil.buildFailedResponseEntity();
		}

		return controllerUtil.getResponseEntity();
	}

}
