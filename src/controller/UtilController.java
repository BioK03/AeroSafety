package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.LearnerService;
import metier.Learner;
import metier.SendEmail;

@Controller
public class UtilController extends MultiActionController {
	
	@Resource
	HttpSession session;
	
	/*@Resource
	HttpSession session =request.getSession();
	request.setAttribute("user", session.getAttribute("user"));*/
	
	@RequestMapping(value="login.htm")
	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception
	{

		request.setAttribute("user", session.getAttribute("user"));	
		
		return new ModelAndView("General/login");
	}
	
	
	@RequestMapping(value="loginValidate.htm")
	public ModelAndView loginValidate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Learner> learners;
		LearnerService lService = new LearnerService();
		learners = lService.search(request.getParameter("email"));
		
		String pass=request.getParameter("password");
		for(Learner l : learners){
			if(l.getMdp().equals(pass)){
				session=null;
				session=request.getSession();
				session.setAttribute("user", l);
				
				request.setAttribute("user", session.getAttribute("user"));	
				request.setAttribute("message", "Connexion réussie");				
				return new ModelAndView("General/login");
			}
		}
		request.setAttribute("message", "Mauvais email ou mot de passe");
		return new ModelAndView("General/login");
	}
	
	@RequestMapping(value="logout.htm")
	public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		session.removeAttribute("user");
		
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="register.htm")
	public ModelAndView register(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		request.setAttribute("user", session.getAttribute("user"));	

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
			l.setMdp(request.getParameter("password"));
			
			LearnerService lService = new LearnerService();
			lService.insertLearner(l);
			
			session=null;
			session=request.getSession();
			session.setAttribute("user", l);
			
			request.setAttribute("user", session.getAttribute("user"));	
			//SendEmail.sendMail("Votre insription sur le site AeroSafety a été effectuée avec succès.", request.getParameter("email"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView("General/register");
	}
	
	@RequestMapping(value="dashboard.htm")
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		LearnerService lService = new LearnerService();
		Learner l = lService.find(1);
		request.setAttribute("learner", l);
		
		MissionService mService = new MissionService();
		request.setAttribute("missions", mService.findAll());
		
		
		
		return new ModelAndView("General/dashboard");
	}
	
	@RequestMapping(value="mission.htm")
	public ModelAndView mission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		
		return new ModelAndView("General/dashboard");
	}
