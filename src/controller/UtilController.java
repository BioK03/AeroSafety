package controller;

import java.sql.Date;
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

import dao.ActionService;
import dao.InscriptionActionService;
import dao.InscriptionService;
import dao.LearnerService;
import dao.MissionService;
import metier.Action;
import metier.Indicator;
import metier.Inscription;
import metier.InscriptionAction;
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
	
	@RequestMapping(value="missionValidate.htm")
	public ModelAndView missionValidate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Inscription inscription = new Inscription();
		
		java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
	    inscription.setDate(sqlDate);
		
		//HttpSession session =request.getSession();
		//inscritpion.setLearner((Learner)session.getAttribute("user"));
	    
		inscription.setLearner(new LearnerService().find(1));
		
		MissionService ms = new MissionService();
		inscription.setMission(ms.find(Integer.parseInt(request.getParameter("missionId"))));
		
		InscriptionService is = new InscriptionService();
		is.insert(inscription);
		
		InscriptionActionService ias = new InscriptionActionService();
		ActionService as = new ActionService();
		
		String answers = request.getParameter("globalAnswer");
		String[] actionAnswers = answers.split("\\$");
		
		int a=1;
		List<Action> previousActions = new ArrayList();
		for(String s:actionAnswers)
		{
			InscriptionAction incriptionAction = new InscriptionAction();
			String[] answerForAction = s.split("\\|");
			List<Integer> checkedIndicators = new ArrayList();
			for(int i=1; i<answerForAction.length; i++)
			{
				checkedIndicators.add(Integer.parseInt(answerForAction[i]));
			}
			
			Action action = as.find(Integer.parseInt(answerForAction[0]));
			incriptionAction.setAction(action);
			incriptionAction.setInscription(inscription);
			incriptionAction.setSort(a);
			
			int score = 0;
			if(action.getAction() == null || previousActions.contains(action.getAction()))
			{
				score = 0;
			}
			for(Indicator indicator:action.getIndicators())
			{
				if(checkedIndicators.contains(indicator.getId()))
				{
					score += indicator.getValueIfCheck();
				}
				else
				{
					score += indicator.getValueIfUnCheck();
				}
			}
			
			incriptionAction.setScore(score);
			ias.insert(incriptionAction);
			
			previousActions.add(action);
			a++;
		}
		
		return new ModelAndView("redirect:/dashboard.htm");
		
	}
	
	@RequestMapping(value="infos.htm")
	public ModelAndView infos(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return new ModelAndView("General/infos");
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
