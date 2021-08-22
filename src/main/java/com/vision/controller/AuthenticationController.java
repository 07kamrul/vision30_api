package com.vision.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vision.config.CustomUserDetailsService;
import com.vision.config.JwtUtil;
import com.vision.model.UsersModel;
import com.vision.repository.IUsersDao;
import com.vision.service.IUsersService;
import com.vision.util.IControllerUtil;
import com.vision.util.IEncoderDecoder;
import com.vision.util.ServiceUtil;
import com.vision.util.Utility;
import com.vision.viewmodel.AuthRequestViewModel;
import com.vision.viewmodel.AuthResponseViewModel;

import io.jsonwebtoken.impl.DefaultClaims;

@RestController
public class AuthenticationController {
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private IUsersService userService;

	@Autowired
	private IUsersDao usersDao;

	@Autowired
	IControllerUtil controllerUtil;

	@Autowired
	IEncoderDecoder encoderDecoder;

	@Autowired
	private ServiceUtil serviceUtill;

	@Value("${saltKeyFrontend}")
	private String saltKeyFrontend;

	@Autowired
	private JwtUtil jwtUtil;

	@PostMapping("/user_authentication")
	public ResponseEntity<?> createAuthenticationToken(HttpServletRequest request,
			@RequestHeader("latLng") String latLng, @RequestBody AuthRequestViewModel requestViewModel)
			throws Exception {

		Map<String, Object> dataMap = new HashMap<>();

		String username = Utility.removeSpaceAndMakeUsernameLowerCaseTrim(requestViewModel.getUsername());
		List<UsersModel> userPassword = usersDao.findByUsername(username);
		String password = userPassword.get(0).getUserPassword();

		try {
			Authentication auth = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(username, password));
			// -------------This credential is from front end
			if (auth.isAuthenticated()) {
				System.out.println("---------------------[] Auth true");
			}

		} catch (DisabledException e) {
			System.out.println("---------------Ex 1");
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			System.out.println("---------------Ex 2");
			throw new Exception("INVALID_CREDENTIALS", e);
		}

		UserDetails userdetails = userDetailsService.loadUserByUsername(username);
		String token = jwtUtil.generateToken(userdetails);

		final Date date = jwtUtil.getExpirationDateFromToken(token);

		System.out.println("Expired Date " + date.toString());
		List<UsersModel> usersList = usersDao.findByUsername(username);

		if (usersList != null && usersList.size() > 0) {
			dataMap.put("user", usersList.get(0));
		}
		return ResponseEntity.ok(new AuthResponseViewModel(token, date.toString(), dataMap));
	}

	@RequestMapping(value = "/refreshtoken", method = RequestMethod.GET)
	public ResponseEntity<?> refreshtoken(HttpServletRequest request) throws Exception {
		// From the HttpRequest get the claims
		DefaultClaims claims = (io.jsonwebtoken.impl.DefaultClaims) request.getAttribute("claims");

		Map<String, Object> expectedMap = getMapFromIoJsonwebtokenClaims(claims);
		String token = jwtUtil.doGenerateRefreshToken(expectedMap, expectedMap.get("sub").toString());
		final Date date = jwtUtil.getExpirationDateFromToken(token);

		System.out.println("Refresh Token Expired Date " + date.toString());
		return ResponseEntity.ok(new AuthResponseViewModel(token, date.toString(), null));
	}

	public Map<String, Object> getMapFromIoJsonwebtokenClaims(DefaultClaims claims) {
		Map<String, Object> expectedMap = new HashMap<String, Object>();
		for (Entry<String, Object> entry : claims.entrySet()) {
			expectedMap.put(entry.getKey(), entry.getValue());
		}
		return expectedMap;
	}
}
