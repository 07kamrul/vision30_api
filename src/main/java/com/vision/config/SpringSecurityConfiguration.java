package com.vision.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private CustomUserDetailsService userDetailsService;

	@Autowired
	private CustomJwtAuthenticationFilter customJwtAuthenticationFilter;

	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	/**
	 * Delete from permitAll ---> "/generate_ui_code",
	 * "/get_pending_list_for_approval", "/update_pending_list_approval_status",
	 * "/notification/topic", "/update_server_location", "/get_server_locations",
	 * "/add_agency_team_member","/get_my_agency_team","/get_agencies_by_username
	 * search_agency, ok, search_agency_units, get_units_by_ids
	 */

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().cors().disable().authorizeRequests().antMatchers("/helloadmin").hasRole("ADMIN")
				.antMatchers("/users_by_usernames", "/get_app_sync_indicators").hasAnyRole("USER", "ADMIN")
				.antMatchers("/user_authentication", "/user_by_username", "/update_user_current_location",
						"/reset_user_password", "/update_user_password", "/add_user_form", "/request_for_otp",
						"/validate_employee_by_agency_and_role", "/get_agency_employees_by_ids",
						"/update_user_role_by_app_code", "/get_agency_employee_by_reporting_manager",
						"/get_employee_by_agency_and_username", "/get_employee_by_agency_and_usernames",
						"/generate_ui_code", "/get_pending_list_for_approval", "/update_pending_list_approval_status",
						"/notification/topic", "/update_server_location", "/get_server_locations",
						"/add_agency_team_member", "/get_my_agency_team", "/get_agencies_by_username", "/search_user",
						"/get_agency_details_by_id", "/get_user_current_location", "/search_agency",
						"/get_notices_by_agency", "/search_agency_units", "/get_units_by_ids", "/get_unit_tree")
				.permitAll().anyRequest().authenticated().and().exceptionHandling()
				.authenticationEntryPoint(jwtAuthenticationEntryPoint).and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
				.addFilterBefore(customJwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}

}
