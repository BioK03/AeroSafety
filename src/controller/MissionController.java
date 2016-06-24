package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import dao.ActionService;
import dao.IndicatorService;
import dao.InscriptionActionService;
import dao.InscriptionService;
import dao.LearnerService;
import dao.MissionService;
import metier.Inscription;
import metier.InscriptionAction;
import metier.Mission;

@Controller
public class MissionController extends MultiActionController {

	// TODO Adapt these functions to the Service class
	// TODO Manage errors (error page? Flashbag?)

	@RequestMapping(value = "addMission.htm")
	public ModelAndView addMission(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("id");
		MissionService aService = new MissionService();
		if (id != null) {
			request.setAttribute("mission", aService.find(Integer.parseInt(id)));
		}

		ActionService acService = new ActionService();
		request.setAttribute("actions", acService.findAll());

		LearnerService lService = new LearnerService();
		request.setAttribute("learners", lService.findAll());

		return new ModelAndView("Mission/add");
	}

	@RequestMapping(value = "associateValidate.htm")
	public ModelAndView associateValidate (HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean hasLearner = request.getParameter("learner_id") != null;
		boolean hasAction = request.getParameter("action_id") != null;
		boolean hasMission = request.getParameter("mission_id") != null;
		
		if(hasAction && hasLearner && hasMission){
			int learner_id = Integer.parseInt(request.getParameter("learner_id"));
			int mission_id = Integer.parseInt(request.getParameter("mission_id"));
			int action_id = Integer.parseInt(request.getParameter("action_id"));
			boolean done = false;
			MissionService ms = new MissionService();
			InscriptionService is = new InscriptionService();
			InscriptionActionService ias = new InscriptionActionService();
			ActionService as = new ActionService();
			Mission m = ms.find(mission_id);
			
			for(Inscription i : m.getInscriptions()){
				if(i.getMission().equals(m)){
					
					InscriptionAction ia = new InscriptionAction();
					ia.setAction(as.find(action_id));
					ia.setInscription(i);
					i.getInscriptionActions().add(ia);
					ias.insert(ia);
					is.merge(i);
					done = true;
				}
			}
		}
		
		return listMission(request, response);
	}
	
	@RequestMapping(value = "associate.htm")
	public ModelAndView associateItems(HttpServletRequest request, HttpServletResponse response) throws Exception {
		boolean hasLearner = request.getParameter("learner_id") != null;
		boolean hasAction = request.getParameter("action_id") != null;
		boolean hasMission = request.getParameter("mission_id") != null;

		if (hasLearner && !hasAction && !hasMission) {
			int learner_id = Integer.parseInt(request.getParameter("learner_id"));
			MissionService ms = new MissionService();
			LearnerService ls = new LearnerService();
			List<Mission> lMission = ms.getMissionsByUser(learner_id);
			request.setAttribute("learner", ls.find(learner_id));
			request.setAttribute("missions", lMission);
			if (lMission.size() == 1) {
				request.setAttribute("actions", lMission.get(0).getActions());
			}
		} else if (!hasLearner && !hasAction && hasMission) {
			int mission_id = Integer.parseInt(request.getParameter("mission_id"));
			LearnerService ls = new LearnerService();
			MissionService ms = new MissionService();
			request.setAttribute("mission", ms.find(mission_id));
			request.setAttribute("learners", ls.getUserByMission(mission_id));
			request.setAttribute("actions", ms.find(mission_id).getActions());
		} else if (!hasLearner && hasAction && !hasMission) {
			int action_id = Integer.parseInt(request.getParameter("action_id"));
			ActionService as = new ActionService();
			request.setAttribute("missions", as.find(action_id).getMissions());
			request.setAttribute("action", as.find(action_id));
			request.setAttribute("needJS", true);
		}

		return new ModelAndView("Mission/associate");
	}

	@RequestMapping(value = "addValidateMission.htm")
	public ModelAndView createMission(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MissionService mService = new MissionService();
		boolean isEdit = request.getParameter("id") != null;
		Mission mis = !isEdit ? new Mission() : mService.find(Integer.parseInt(request.getParameter("id")));

		mis.setWording(request.getParameter("wording"));

		if (request.getParameterValues("actions") != null) {
			ActionService aService = new ActionService();
			for (String s : request.getParameterValues("actions")) {
				mis.getActions().add(aService.find(Integer.parseInt(s)));
			}
		}

		mService.insertMission(mis);

		if (request.getParameterValues("learners") != null) {
			LearnerService lService = new LearnerService();
			InscriptionService iService = new InscriptionService();
			for (String s : request.getParameterValues("learners")) {
				Inscription i = new Inscription();
				i.setMission(mis);
				i.setLearner(lService.find(Integer.parseInt(s)));
				iService.insertInscription(i);
				mis.getInscriptions().add(i);
			}
		}

		if (!isEdit)
			mService.insertMission(mis);
		else
			mService.merge(mis);

		return listMission(request, response);
	}

	@RequestMapping(value = "detailsMission.htm")
	public ModelAndView detailsMission(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MissionService mService = new MissionService();
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("mission", mService.find(id));
		request.setAttribute("cascade", mService.getCascade(id));
		return new ModelAndView("Mission/details");
	}

	@RequestMapping(value = "listMission.htm")
	public ModelAndView listMission(HttpServletRequest request, HttpServletResponse response) throws Exception {
		MissionService mService = new MissionService();
		request.setAttribute("missions", mService.findAll());
		return new ModelAndView("Mission/list");
	}

	@RequestMapping(value = "deleteMission.htm")
	public ModelAndView removeMission(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		MissionService mService = new MissionService();
		Mission m = mService.find(id);
		request.setAttribute("mission", m);
		request.setAttribute("hasInscriptions", !m.getInscriptions().isEmpty());
		return new ModelAndView("Mission/remove");
	}

	@RequestMapping(value = "deleteValidateMission.htm")
	public ModelAndView deleteMission(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int id = Integer.parseInt(request.getParameter("id"));
		MissionService mService = new MissionService();
		mService.delete(id);
		return new ModelAndView("Mission/list");
	}
}
