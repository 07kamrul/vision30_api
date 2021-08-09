package com.vision.service;

import java.util.List;
import java.util.Map;

import com.vision.model.UsersModel;
import com.vision.viewmodel.MasterViewModel;

public interface IUsersService {

	public Map<String, Object> getUser(MasterViewModel viewModel);

	public Map<String, Object> getUserByIds(MasterViewModel viewModel);

	public Map<String, Object> addUser(UsersModel model, MasterViewModel viewModel);

	public Map<String, Object> addAllUser(List<UsersModel> models, MasterViewModel viewModel);

	public Map<String, Object> searchUser(MasterViewModel viewModel);

	public Map<String, Object> deleteUserByIds(MasterViewModel viewModel);

}
