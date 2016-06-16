package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.GameService;
import dao.GoalService;
import dao.IndicatorService;
import dao.MissionService;
import metier.Mission;

@Controller
public class MissionController extends MultiActionController {

	//TODO Adapt these functions to the Service class
	//TODO Manage errors (error page? Flashbag?)
	
	@RequestMapping(value="addMission.htm")
	public ModelAndView addMission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String id = request.getParameter("id");
		MissionService aService = new MissionService();
		if(id != null){
			request.setAttribute("mission", aService.find(Integer.parseInt(id)));
		}
		GameService gService = new GameService();
		request.setAttribute("games", gService.findAll());
		
		GoalService goService = new GoalService();
		request.setAttribute("goals", goService.findAll());
		return new ModelAndView("Mission/add");
	}
	
	@RequestMapping(value="addValidateMission.htm")
	public ModelAndView createMission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Mission mis = new Mission();
		GameService gService = new GameService();
		
		mis.setWording(request.getParameter("wording"));
		mis.setGame(gService.find(Integer.parseInt(request.getParameter("fk_game"))));

		MissionService mService = new MissionService();
		mService.insertMission(mis);
		
		listMission(request, response);
		
		return new ModelAndView("Mission/list");
	}
	
	@RequestMapping(value="detailsMission.htm")
	public ModelAndView detailsMission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		MissionService mService = new MissionService();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("myMission", mService.find(id));
		return new ModelAndView("Mission/details");
	}
	
	@RequestMapping(value="listMission.htm")
	public ModelAndView listMission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		MissionService mService = new MissionService();
		request.setAttribute("missions", mService.findAll());
		return new ModelAndView("Mission/list");
	}
	
	@RequestMapping(value="deleteMission.htm")
	public ModelAndView removeMission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		MissionService mService = new MissionService();
		//Attente de l'implémentation du service associé
		
		
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("myMission", aService.detailsMission(id));
		return new ModelAndView("Mission/remove");
	}

	@RequestMapping(value="deleteValidateMission.htm")
	public ModelAndView deleteMission(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		MissionService mService = new MissionService();
		//Attente de l'implémentation du service associé
		
		
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//aService.deleteMission(id);
		return new ModelAndView("Mission/list");
	}
}
