package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.ActionService;
import dao.IndicatorService;
import metier.Indicator;

@Controller
public class IndicatorController extends MultiActionController {

	// TODO Adapt these functions to the Service class
	// TODO Manage errors (error page? Flashbag?)

	@RequestMapping(value = "addIndicator.htm")
	public ModelAndView addIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		IndicatorService aService = new IndicatorService();
		if (id != null) {
			request.setAttribute("indicator", aService.find(Integer.parseInt(id)));
		}

		ActionService acService = new ActionService();
		request.setAttribute("actions", acService.findAll());

		return new ModelAndView("Indicator/add");
	}

	@RequestMapping(value = "addValidateIndicator.htm")
	public ModelAndView createIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception {
		IndicatorService iService = new IndicatorService();

		boolean isEdit = request.getParameter("id") != null;

		Indicator ind = !isEdit ? new Indicator() : iService.find(Integer.parseInt(request.getParameter("id")));

		ActionService acService = new ActionService();

		ind.setWording(request.getParameter("wording"));
		ind.setValueIfCheck(Integer.parseInt(request.getParameter("valueIfCheck")));
		ind.setValueIfUnCheck(Integer.parseInt(request.getParameter("valueIfUnCheck")));

		ind.setAction(acService.find(Integer.parseInt(request.getParameter("fk_action"))));

		if (!isEdit)
			iService.insertIndicator(ind);
		else
			iService.merge(ind);
		
		listIndicator(request, response);
		return new ModelAndView("Indicator/list");
	}

	@RequestMapping(value = "detailsIndicator.htm")
	public ModelAndView detailsIndicators(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		IndicatorService iService = new IndicatorService();
		request.setAttribute("indicator", iService.find(id));
		return new ModelAndView("Indicator/details");
	}

	@RequestMapping(value = "listIndicator.htm")
	public ModelAndView listIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception {
		IndicatorService iService = new IndicatorService();
		request.setAttribute("indicators", iService.findAll());
		return new ModelAndView("Indicator/list");
	}

	@RequestMapping(value = "deleteIndicator.htm")
	public ModelAndView removeIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		IndicatorService iService = new IndicatorService();
		Indicator ind = iService.find(id);
		request.setAttribute("indicator", ind);
		return new ModelAndView("Indicator/remove");
	}

	@RequestMapping(value = "deleteValidateIndicator.htm")
	public ModelAndView deleteIndicator(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		IndicatorService iService = new IndicatorService();
		iService.delete(id);
		return listIndicator(request, response);
	}

}
