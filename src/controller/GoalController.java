package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.ActionService;
import dao.GameService;
import dao.GoalService;
import dao.MissionService;
import metier.Game;
import metier.Goal;

@Controller
public class GoalController extends MultiActionController {

	//TODO Adapt these functions to the Service class
	//TODO Manage errors (error page? Flashbag?)
	
	@RequestMapping(value="addGoal.htm")
	public ModelAndView addGoal(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String id = request.getParameter("id");
		GoalService aService = new GoalService();
		if(id != null){
			request.setAttribute("goal", aService.find(Integer.parseInt(id)));
		}
		
		MissionService mService = new MissionService();
		request.setAttribute("missions", mService.findAll());
		
		ActionService acService = new ActionService();
		request.setAttribute("actions", acService.findAll());
		return new ModelAndView("Goal/add");
	}
	
	@RequestMapping(value="addValidateGoal.htm")
	public ModelAndView createGoal(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Goal gam=new Goal();
		gam.setWording(request.getParameter("wording"));
		
		GoalService aService = new GoalService();
		aService.insertGoal(gam);
		
		listGoal(request,response);
		return new ModelAndView("Goal/list");
	}
	
	@RequestMapping(value="detailsGoal.htm")
	public ModelAndView detailsGoal(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		GoalService aService = new GoalService();
		request.setAttribute("goal", aService.find(id));
		return new ModelAndView("Goal/details");
	}
	
	@RequestMapping(value="listGoal.htm")
	public ModelAndView listGoal(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		GoalService aService = new GoalService();
		request.setAttribute("goals", aService.findAll());
		return new ModelAndView("Goal/list");
	}
	
	@RequestMapping(value="deleteGoal.htm")
	public ModelAndView removeGoal(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("myGoal", aService.detailsGoal(id));
		return new ModelAndView("Goal/remove");
	}
	
	@RequestMapping(value="deleteValidateGoal.htm")
	public ModelAndView deleteGoal(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//aService.deleteGoal(id);
		return new ModelAndView("Goal/list");
	}
	
}
