package com.vision.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.vision.model.UserRolesModel;
import com.vision.model.UsersModel;
import com.vision.repository.IUserRolesDao;
import com.vision.repository.IUsersDao;

@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private IUsersDao userDao;

	@Autowired
	private IUserRolesDao userRoleDao;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		List<SimpleGrantedAuthority> roles = null;
		List<UsersModel> users = userDao.getUserByUsernameOrEmail(username);
		List<UserRolesModel> userRoles = userRoleDao.getRoleByUsernameOrEmail(username);
		if (users != null && users.size() > 0) {
			for (UserRolesModel role : userRoles) {

			}
			roles = Arrays.asList(new SimpleGrantedAuthority(userRoles.get(0).getRole()));
			return new User(users.get(0).getUsername(), users.get(0).getUserPassword(), roles); // ------------- This
		}
		throw new UsernameNotFoundException("User not found with the name " + username);
	}

}
