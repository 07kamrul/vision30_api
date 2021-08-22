package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.UserRolesModel;
import com.vision.viewmodel.MasterViewModel;

public interface IUserRolesService {

	public Map<String, Object> getUserRole(MasterViewModel viewModel);

	public Map<String, Object> getUserRoleByIds(MasterViewModel viewModel);

	public Map<String, Object> addUserRole(UserRolesModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllUserRole(List<UserRolesModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchUserRole(MasterViewModel viewModel);

	public Map<String, Object> deleteUserRoleByIds(MasterViewModel viewModel);

}
