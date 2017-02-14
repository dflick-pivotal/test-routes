package com.example;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	
    @RequestMapping("/ui")
    public String getUi()
	{
		return "UI Endpunkt";
	}

	@RequestMapping("/rest")
	public String getRest()
	{
		return "Rest Endpunkt";
	}
}
