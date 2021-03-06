package com.mycom.blog.controller.api;

import java.io.Console;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.blog.auth.PrincipalDetail;
import com.mycom.blog.controller.assist.ConAssist;
import com.mycom.blog.dto.ChatRoom;
import com.mycom.blog.dto.User;
import com.mycom.blog.dto.enumtype.AuthType;
import com.mycom.blog.dto.enumtype.RoleType;
import com.mycom.blog.model.Response;
import com.mycom.blog.repository.ChatRoomRepository;
import com.mycom.blog.service.UserService;

@RestController
@RequestMapping(value = { "/auth" })
public class AuthApiController {

	@Autowired
	private UserService userService;

	@Autowired
	private ConAssist conAssist;
//	@Autowired
//	HttpSession session;

	@PostMapping("/joinProc")
	public Response<Integer> normalSignUp(@RequestBody User user) {

		try {
			System.out.println("UserApiController : save ");

			int result = userService.signUp(user);

			return new Response<Integer>(HttpStatus.OK.value(), result);
		} catch (Exception e) {
			e.printStackTrace();
			return new Response<Integer>(HttpStatus.INTERNAL_SERVER_ERROR.value(), -1);
		}
	}



}
