package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.TermsConditionsModel;
import com.vision.viewmodel.MasterViewModel;

public interface ITermsConditionsService {

	public Map<String, Object> getTermsCondition(MasterViewModel viewModel);

	public Map<String, Object> getTermsConditionByIds(MasterViewModel viewModel);

	public Map<String, Object> addTermsCondition(TermsConditionsModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllTermsCondition(List<TermsConditionsModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchTermsCondition(MasterViewModel viewModel);

	public Map<String, Object> deleteTermsConditionByIds(MasterViewModel viewModel);

}
