package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.LearnerService;
import metier.Game;
import metier.Learner;
import metier.SendEmail;

@Controller
public class UtilController extends MultiActionController {
	
	
	
	@RequestMapping(value="login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return new ModelAndView("General/login");
	}
	
	@RequestMapping(value="loginValidate.htm")
	public ModelAndView loginValidate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		return new ModelAndView("General/login");
	}
	
	@RequestMapping(value="register.htm")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return new ModelAndView("General/register");
	}
	
	@RequestMapping(value="registerValidate.htm")
	public ModelAndView registerValidate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try {
			Learner l = new Learner();
			l.setEmail(request.getParameter("email"));
			l.setForname(request.getParameter("firstname"));
			l.setSurname(request.getParameter("lastname"));
			
			//LearnerService.
			SendEmail.sendMail("Votre insription sur le site AeroSafety a été effectuée avec succès.", request.getParameter("email"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("General/register");
	}
	
	@RequestMapping(value="dashboard.htm")
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LearnerService lService = new LearnerService();
		Learner l = lService.find(12);
		
		request.setAttribute("learner", l);
		
		return new ModelAndView("General/dashboard");
	}
}
