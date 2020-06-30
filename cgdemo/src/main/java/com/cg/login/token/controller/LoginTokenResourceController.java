package com.cg.login.token.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.constant.Constants;

@RestController
public class LoginTokenResourceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginTokenResourceController.class);
	private static final String SESSION_STATUS_ACTIVE = "Session Active!";
	private static final String SESSION_STATUS_LOGOUT = "Logout Successful";

	@GetMapping("/token")
	@ResponseBody
	public ResponseEntity token(HttpSession sessioHttpSession, HttpServletRequest httpServletRequest) {

        String remoteHost = httpServletRequest.getRemoteHost();
        String remoteAddr = httpServletRequest.getRemoteAddr();
        Integer remotePort = httpServletRequest.getRemotePort();


        LOGGER.info("Remote Host: {}", remoteHost);
        LOGGER.info("Remote Post: {}", remotePort);
        LOGGER.info("Remote Addr: {}", remoteAddr);
        return new ResponseEntity<>(Collections.singletonMap("token", sessioHttpSession.getId()), HttpStatus.OK);

	}

	/*
	 * @GetMapping("/checkSession") public ResponseEntity checkSession() {
	 * System.out.println("Hi"); return new
	 * ResponseEntity("Session Active",HttpStatus.OK); }
	 */

	@GetMapping("/checksession")
	@ResponseBody
	public ResponseEntity<String> checkSession() {
		final String respMsg = String.format(Constants.RESP_JSON_FORMAT, SESSION_STATUS_ACTIVE);
		System.out.println(respMsg);
		return new ResponseEntity<>(respMsg, HttpStatus.OK);
	}

	@PostMapping("/user/logout")//Default /logout in spring security dont user
	 public ResponseEntity logout(HttpServletRequest request) {
		SecurityContextHolder.clearContext();
        return new ResponseEntity<>("logout", HttpStatus.ACCEPTED);
    }
}
