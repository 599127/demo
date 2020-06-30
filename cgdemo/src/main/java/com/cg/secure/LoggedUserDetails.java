package com.cg.secure;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cg.dto.UserDto;
import com.cg.enums.UserActive;
public class LoggedUserDetails implements UserDetails{

	 
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
	private String userName;
	private String password;
	private boolean active;
	private List<GrantedAuthority> authorities;

	public LoggedUserDetails(UserDto user) {
		this.name = user.getUsername();
		this.id = user.getId();
		this.userName = user.getEmail();
		this.password = user.getPassword();
		this.active = user.getFlgauth().equals(UserActive.ACTIVE.getCode());
		this.authorities = Arrays.stream(user.getRole().toUpperCase().split(","))
							.map(SimpleGrantedAuthority::new)
							.collect(Collectors.toList());
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return active;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
