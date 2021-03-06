package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.LearnerService;
import dao.MissionService;
import metier.Inscription;
import metier.Learner;

@Controller
public class LearnerController extends MultiActionController {

	@RequestMapping(value = "addLearner.htm")
	public ModelAndView addLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		LearnerService aService = new LearnerService();
		if (id != null) {
			request.setAttribute("learner", aService.find(Integer.parseInt(id)));
		}

		MissionService mService = new MissionService();
		request.setAttribute("missions", mService.findAll());

//		ActionService acService = new ActionService();
//		request.setAttribute("actions", acService.findAll());

		return new ModelAndView("Learner/add");
	}

	@RequestMapping(value = "addValidateLearner.htm")
	public ModelAndView createLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LearnerService lService = new LearnerService();
		boolean isEdit = request.getParameter("id") != null;
		Learner lea = !isEdit ? new Learner() : lService.find(Integer.parseInt(request.getParameter("id")));

		lea.setForname(request.getParameter("forname"));
		lea.setSurname(request.getParameter("surname"));
		lea.setEmail(request.getParameter("email"));
		String mdp = request.getParameter("mdp");
		if (mdp != null && !mdp.equals("")) {
			lea.setMdp(mdp);
		}
		// Todo salt ?

		MissionService mService = new MissionService();
		if (request.getParameterValues("missions") != null) {
			for (String s : request.getParameterValues("missions")) {
				Inscription i = new Inscription();
				i.setLearner(lea);
				i.setMission(mService.find(Integer.parseInt(s)));
				lea.getInscriptions().add(i);
			}
		}

		if (!isEdit)
			lService.insert(lea);
		else
			lService.merge(lea);

		listLearner(request, response);
		return new ModelAndView("Learner/list");
	}

	@RequestMapping(value = "detailsLearner.htm")
	public ModelAndView detailsLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		LearnerService lService = new LearnerService();
		request.setAttribute("learner", lService.find(id));
		return new ModelAndView("Learner/details");
	}

	@RequestMapping(value = "listLearner.htm")
	public ModelAndView listLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {
		LearnerService lService = new LearnerService();
		request.setAttribute("learners", lService.findAll());
		return new ModelAndView("Learner/list");
	}

	@RequestMapping(value = "deleteLearner.htm")
	public ModelAndView removeLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		LearnerService lService = new LearnerService();
		Learner l = lService.find(id);
		request.setAttribute("learner", l);
		request.setAttribute("cascade", lService.getCascade(id));
		request.setAttribute("hasInscriptions", !l.getInscriptions().isEmpty());
		return new ModelAndView("Learner/remove");
	}

	@RequestMapping(value = "deleteValidateLearner.htm")
	public ModelAndView deleteLearner(HttpServletRequest request, HttpServletResponse response) throws Exception {

		int id = Integer.parseInt(request.getParameter("id"));
		LearnerService lService = new LearnerService();
		lService.delete(id);
		return listLearner(request, response);
	}
}
