package controller;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import metier.Action;
import metier.Game;
import metier.Goal;
import metier.Learner;
import metier.Mission;
import metier.SendEmail;
import dao.ActionService;
import dao.GameService;
import dao.GoalService;
import dao.LearnerService;
import dao.MissionService;

@Controller
public class BaseController extends MultiActionController {

	@RequestMapping(value="index.htm")
	public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return new ModelAndView("index");
	}
	
	@RequestMapping(value="/")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return index(request, response);
	}
	
	
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
	
	@RequestMapping(value="contact.htm")
	public ModelAndView contact(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return new ModelAndView("General/contact");
	}
	
	@RequestMapping(value="contactValidate.htm")
	public ModelAndView contactValidate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{		
		try {
			SendEmail.sendMail("FROM "+request.getParameter("name")+" ( "+request.getParameter("email")+" ) : "+request.getParameter("content"), "contact.aerosafety@gmail.com");
			
			SendEmail.sendMail("Votre message : \n\n "+request.getParameter("content")+"\n\n a été transféré avec succès, vous recevrez une réponse sous 48h.", request.getParameter("mail"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("General/contact");
	}
	
	@RequestMapping(value="infos.htm")
	public ModelAndView infos(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		return new ModelAndView("General/infos");
	}
	
	@RequestMapping(value="search.htm")
	public ModelAndView search(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String search = request.getParameter("search").toLowerCase();
		
		List<String[]> result = new ArrayList();
		if(search.contains("apprenant") || search.contains("learner"))
		{
			if(search.contains("list"))
			{
				return new ModelAndView("redirect:listLearner.htm");
			}
			else
			{
				
				String searchLearner = search.replace("learners", "");
				searchLearner = searchLearner.replace("learner", "");
				searchLearner = searchLearner.replace("apprenants", "");
				searchLearner = searchLearner.replace("apprenant", "");
				
				LearnerService lService = new LearnerService();
				List<Learner> lrns = lService.search(searchLearner.trim());
				
				for(int i=0; i<lrns.size(); i++)
				{
					String [] temp = new String[2];
					temp[0]="detailsLearner.htm?id="+lrns.get(i).getId();
					temp[1]=lrns.get(i).getForname()+" "+lrns.get(i).getSurname();
					result.add(temp);
				}
			}
		}
		if(search.contains("action"))
		{
			if(search.contains("list"))
			{
				return new ModelAndView("redirect:listAction.htm");
			}
			else
			{
				String searchAction = search.replace("actions", "");
				searchAction = searchAction.replace("action", "");
				
				ActionService aService = new ActionService();
				List<Action> acts = aService.search(searchAction.trim());
				
				for(int i=0; i<acts.size(); i++)
				{
					String [] temp = new String[2];
					temp[0]="detailsAction.htm?id="+acts.get(i).getId();
					temp[1]=acts.get(i).getWording();
					result.add(temp);
				}
			}
		}
		if(search.contains("jeu") || search.contains("game"))
		{
			if(search.contains("list"))
			{
				return new ModelAndView("redirect:listGame.htm");
			}
			else
			{
				String searchGame = search.replace("games", "");
				searchGame = searchGame.replace("game", "");
				searchGame = searchGame.replace("jeux", "");
				searchGame = searchGame.replace("jeu", "");
				
				GameService gService = new GameService();
				List<Game> gms = gService.search(searchGame.trim());
				
				for(int i=0; i<gms.size(); i++)
				{
					String [] temp = new String[2];
					temp[0]="detailsGame.htm?id="+gms.get(i).getId();
					temp[1]=gms.get(i).getWording();
					result.add(temp);
				}
			}
		}
		if(search.contains("objectif") || search.contains("goal"))
		{
			if(search.contains("list"))
			{
				return new ModelAndView("redirect:listGoal.htm");
			}
			else
			{
				String searchGoal = search.replace("objectifs", "");
				searchGoal = searchGoal.replace("objectif", "");
				searchGoal = searchGoal.replace("goals", "");
				searchGoal = searchGoal.replace("goal", "");
				
				GoalService gService = new GoalService();
				List<Goal> gls = gService.search(searchGoal.trim());
				
				for(int i=0; i<gls.size(); i++)
				{
					String [] temp = new String[2];
					temp[0]="detailsGame.htm?id="+gls.get(i).getId();
					temp[1]=gls.get(i).getWording();
					result.add(temp);
				}
			}
		}
		if(search.contains("indicateur") || search.contains("indicator"))
		{
			if(search.contains("list"))
			{
				return new ModelAndView("redirect:listIndicator.htm");
			}
		}
		if(search.contains("mission"))
		{
			if(search.contains("list"))
			{
				return new ModelAndView("redirect:listMission.htm");
			}
			else
			{
				String searchMission = search.replace("missions", "");
				searchMission = searchMission.replace("mission", "");
				
				MissionService gService = new MissionService();
				List<Mission> mss = gService.search(searchMission.trim());
				
				for(int i=0; i<mss.size(); i++)
				{
					String [] temp = new String[2];
					temp[0]="detailsGame.htm?id="+mss.get(i).getId();
					temp[1]=mss.get(i).getWording();
					result.add(temp);
				}
			}
		}
		if(result.isEmpty())
		{
			String [] temp = new String[2];
			temp[0]="#";
			temp[1]="Pas de résultats";
			result.add(temp);
		}
		

		
		request.setAttribute("result", result);
		request.setAttribute("search", search);
		
		return new ModelAndView("General/search");
	}
	
}
