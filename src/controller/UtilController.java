package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.persistence.sessions.serializers.JSONSerializer;
import org.springframework.core.serializer.Serializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.alibaba.fastjson.JSON;

import dao.InscriptionActionService;
import dao.LearnerService;
import dao.MissionService;
import metier.Learner;
import metier.Mission;
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
		if(session.getAttributeNames().toString().contains("user")){
			request.setAttribute("user", session.getAttribute("user"));	
		}
		
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
		if(session.getAttributeNames().toString().contains("user")){
			request.setAttribute("user", session.getAttribute("user"));	
		}
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
		MissionService mService = new MissionService();
		Mission mission = mService.find(Integer.parseInt(request.getParameter("id")));
		request.setAttribute("mission", mission);
		
		return new ModelAndView("General/mission");
	}
	
	@RequestMapping(value="fetchObject.htm")
	public ModelAndView fetchObject(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Object linkObj = null;
		switch (request.getParameter("linkClass")) {
		case "Learner":
			LearnerService ls = new LearnerService();
			linkObj = ls.find(Integer.parseInt(request.getParameter("linkObjectId")));
			break;
		case "Mission":
			MissionService ms = new MissionService();
			linkObj = ms.find(Integer.parseInt(request.getParameter("linkObjectId")));
		default:
			break;
		}
		
		Object target = null;
		switch (request.getParameter("targetClass")) {
		case "Mission":
			MissionService ms = new MissionService();
			if(linkObj != null)
				target = ms.getMissionsByUser(((Learner) linkObj).getId());
			break;
		case "Learner":
			LearnerService ls = new LearnerService();
			if(linkObj != null)
				target = ls.getUserByMission(((Mission) linkObj).getId());
			break;
		default:
			break;
		}
		
		String content = "Une erreur est survenue";
		if(target != null){
			content = JSON.toJSONString(target);
		}
		request.setAttribute("content", content);
		
		return new ModelAndView("General/fetch");
	}
}
