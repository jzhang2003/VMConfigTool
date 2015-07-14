package com.minli.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minli.web.form.SearchMainForm;

	@Controller
	public class SearchMainController {
	    @RequestMapping(value="/SearchMain")
	    public ModelAndView searchMain(HttpServletRequest request,HttpServletResponse response,SearchMainForm formModel ){	
	    	
			ModelAndView mv = new ModelAndView("/SearchMain" );
		      mv.addObject("userName", formModel.getUserName());
		      mv.addObject("password", formModel.getPassword());
		      mv.addObject("resultStr", "successfully finished");

		      return mv;
	    }
	
}
