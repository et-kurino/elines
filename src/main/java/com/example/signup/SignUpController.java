package com.example.signup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class SignUpController {

	@Autowired
	UserTableDao userTableDao;

	/*@ModelAttribute
	UserDto userDto() {
		return new UserDto();
	}*/

	@RequestMapping(value = "/sign_up")
	public String sign_up() {

		return "sign_up";
	}

	@RequestMapping(value = "/sign_up", method = RequestMethod.POST)
	public String entry(@Validated @ModelAttribute("form") UserDto userDto) {

		int ret = userTableDao.insert(userDto);
		System.out.print(ret);

		return "redirect:/sign_up";

	}

}
