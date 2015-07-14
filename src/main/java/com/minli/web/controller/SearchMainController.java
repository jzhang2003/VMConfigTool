package com.minli.web.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.minli.web.form.SearchMainForm;

	@Controller
	public class SearchMainController {
		
		public static Logger logger = Logger.getLogger(SearchMainController.class);

		
	    @RequestMapping(value="/SearchMain")
	    public ModelAndView searchMain(HttpServletRequest request,HttpServletResponse response,SearchMainForm formModel ){	
	    	
			ModelAndView mv = new ModelAndView("/SearchMain" );
		      mv.addObject("userName", formModel.getUserName());
		      mv.addObject("password", formModel.getPassword());
		      mv.addObject("confMode", formModel.getConfMode());

		      mv.addObject("resultStr", "successfully finished");
			 logger.error("some test log");

			 
			 String parm1 = formModel.getUserName();
			 String parm2 = formModel.getPassword();
			 String parm3 = formModel.getConfMode();

			 
			 BufferedReader br = null;
			 
			 try {
//				Process p = Runtime.getRuntime().exec("cmd.exe /c ipconfig /all");
				Process p = Runtime.getRuntime().exec("f:/test.bat " + parm1 + " " + parm2 + " " + parm3);
				
				br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                String line = null;
                while ((line = br.readLine()) != null) {
       			 logger.info(line);
                }
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 


			 
		      return mv;
	    }
	
}
