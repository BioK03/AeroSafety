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
import dao.LearnerService;
import metier.Game;

@Controller
public class GameController extends MultiActionController {

	//TODO Adapt these functions to the Service class
	//TODO Manage errors (error page? Flashbag?)
	
	@RequestMapping(value="addGame.htm")
	public ModelAndView addGame(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String id = request.getParameter("id");
		GameService aService = new GameService();
		if(id != null){
			request.setAttribute("game", aService.find(Integer.parseInt(id)));
		}
		
		LearnerService lService = new LearnerService();
		request.setAttribute("learners", lService.findAll());
		
		return new ModelAndView("Game/add");
	}
	
	@RequestMapping(value="addValidateGame.htm")
	public ModelAndView createGame(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Game gam=new Game();
		gam.setWording(request.getParameter("wording"));
		
		GameService aService = new GameService();
		aService.insertGame(gam);
		
		listGame(request,response);
		return new ModelAndView("Game/list");
	}
	
	@RequestMapping(value="detailsGame.htm")
	public ModelAndView detailsGame(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		GameService aService = new GameService();
		request.setAttribute("game", aService.find(id));
		return new ModelAndView("Game/details");
	}
	
	@RequestMapping(value="listGame.htm")
	public ModelAndView listGame(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		GameService aService = new GameService();
		request.setAttribute("games", aService.findAll());
		return new ModelAndView("Game/list");
	}
	
	@RequestMapping(value="deleteGame.htm")
	public ModelAndView removeGame(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("myGame", aService.detailsGame(id));
		return new ModelAndView("Game/remove");
	}	
	
	@RequestMapping(value="deleteValidateGame.htm")
	public ModelAndView deleteGame(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//aService.deleteGame(id);
		return new ModelAndView("Game/list");
	}
	
}
