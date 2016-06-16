package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.ActionService;
import dao.IndicatorService;
import metier.Indicator;

@Controller
public class IndicatorController extends MultiActionController {

	//TODO Adapt these functions to the Service class
	//TODO Manage errors (error page? Flashbag?)
	
	@RequestMapping(value="addIndicator.htm")
	public ModelAndView addIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		String id = request.getParameter("id");
		IndicatorService aService = new IndicatorService();
		if(id != null){
			request.setAttribute("indicator", aService.find(Integer.parseInt(id)));
		}
		
		ActionService acService = new ActionService();
		request.setAttribute("actions", acService.findAll());
		
		return new ModelAndView("Indicator/add");
	}
	
	@RequestMapping(value="addValidateIndicator.htm")
	public ModelAndView createIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		Indicator ind = new Indicator();
		ActionService acService = new ActionService();
		
		ind.setWeight(Integer.parseInt(request.getParameter("weight")));
		ind.setAction(acService.find(Integer.parseInt(request.getParameter("fk_action"))));

		IndicatorService iService = new IndicatorService();
		iService.insertIndicator(ind);
		
		listIndicator(request, response);
		return new ModelAndView("Indicator/list");
	}
	
	@RequestMapping(value="detailsIndicator.htm")
	public ModelAndView detailsIndicators(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		System.out.println("TEST FUCKSHIT");
		int id = Integer.parseInt(request.getParameter("id"));
		IndicatorService iService = new IndicatorService();
		request.setAttribute("myIndicator", iService.find(id));
		System.out.println(iService.find(id));
		return new ModelAndView("Indicator/details");
	}
	
	@RequestMapping(value="listIndicator.htm")
	public ModelAndView listIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		IndicatorService iService = new IndicatorService();
		request.setAttribute("indicators", iService.findAll());
		return new ModelAndView("Indicator/list");
	}
	
	@RequestMapping(value="deleteIndicator.htm")
	public ModelAndView removeIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		IndicatorService iService = new IndicatorService();
		//Attente de l'implémentation du service associé
		
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//request.setAttribute("myIndicator", aService.detailsIndicator(id));
		return new ModelAndView("Indicator/remove");
	}
	
	@RequestMapping(value="deleteValidateIndicator.htm")
	public ModelAndView deleteIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		int id = Integer.parseInt(request.getParameter("id"));
		IndicatorService iService = new IndicatorService();
		//Attente de l'implémentation du service associé
		
		//Service aService = new Service();
		//int id = Integer.parseInt(request.getParameter("id"));
		//aService.deleteIndicator(id);
		return new ModelAndView("Indicator/list");
	}
	
}
