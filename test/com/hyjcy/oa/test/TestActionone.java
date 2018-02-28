package com.hyjcy.oa.test;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

@Controller
public class TestActionone extends ActionSupport{
	
/**
 * 
 */
	private static final long serialVersionUID = 1L;
    @Resource
    private TestService testService;
		public String execute() throws Exception {
			System.out.println("-------> TestAction.execute()");
			System.out.println("-------> Testservice="+testService);
			testService.saveTwoUsers();
			return "success";
		}

	
}
