package com.lmc.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pro")
public class ProductTestController {
	
//	@RequestMapping("/info")
//	public String productInfo(){
//		return " some product info ";
//	}
	
	@RequestMapping("/info")
	public String productInfo(){
		String currentUser = "";
		Object principl = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principl instanceof UserDetails) {
			currentUser = ((UserDetails)principl).getUsername();
		}else {
			currentUser = principl.toString();
		}
		return " some product info,currentUser is: "+currentUser;
	}

}
