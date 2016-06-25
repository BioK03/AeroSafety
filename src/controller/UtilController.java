package controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import com.alibaba.fastjson.JSON;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

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
			//There we hash the input password, and compare it to the real password in database
	        byte[] salt = l.getSalt().getBytes();
	        String hashed= hash(pass, salt);
			
			if(l.getMdp().equals(hashed)){
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
	
	//Function that is hashing a password, using a random Salt (both stored in database)
    private static String hash(String password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException, UnsupportedEncodingException{
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
            password.toCharArray(), salt, 1, 256)
        );
        //We transform the hashed password into a Hex String before sending it to the database
        return javax.xml.bind.DatatypeConverter.printHexBinary(key.getEncoded());
    }
	
	@RequestMapping(value="registerValidate.htm")
	public ModelAndView registerValidate(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		try {
			Learner l = new Learner();
			l.setEmail(request.getParameter("email"));
			l.setForname(request.getParameter("firstname"));
			l.setSurname(request.getParameter("lastname"));
			
			String pass=request.getParameter("password");
			//Randomly generated salt. The String version is for the database, the byte[] one is for the hashing
	        String salt = Integer.toHexString(SecureRandom.getInstance("SHA1PRNG").generateSeed(32).hashCode());
	        byte[] saltBytes=salt.getBytes();
	        
			l.setMdp(hash(pass,saltBytes));	//There we hash the password
			l.setSalt(salt);
			
			LearnerService lService = new LearnerService();
			lService.insertLearner(l);
			
			session=null;
			session=request.getSession();
			session.setAttribute("user", l);
			
			request.setAttribute("user", session.getAttribute("user"));	
			SendEmail.sendMail("<img style='width: 100%' src='http://chbe.fr/img/jee/as.png'/><br/>Votre insription sur le site AeroSafety a été effectuée avec succès.<br/><br/>"
					+ "L'équipe G.E.L.<br/><img style='width: 200px' src='http://chbe.fr/img/jee/gel.png'/>", request.getParameter("email"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return new ModelAndView("General/register");
	}
	
	@RequestMapping(value="dashboard.htm")
	public ModelAndView dashboard(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		session=request.getSession();
		Learner user = (Learner)session.getAttribute("user");
		
		LearnerService lService = new LearnerService();
		Learner l = lService.find(user.getId());
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
		
		session =request.getSession();
		inscription.setLearner((Learner)session.getAttribute("user"));
	    
		//inscription.setLearner(new LearnerService().find(1));
		
		MissionService ms = new MissionService();
		inscription.setMission(ms.find(Integer.parseInt(request.getParameter("missionId"))));
		
		InscriptionService is = new InscriptionService();
		is.insert(inscription);
		
		InscriptionActionService ias = new InscriptionActionService();
		ActionService as = new ActionService();
		
		String answers = request.getParameter("globalAnswer");
		if(!answers.trim().isEmpty())
		{
			String[] actionAnswers = answers.split("\\$");
			
			
			
			int a=1;
			List<Action> previousActions = new ArrayList<>();
			for(String s:actionAnswers)
			{
				InscriptionAction incriptionAction = new InscriptionAction();
				String[] answerForAction = s.split("\\|");
				List<Integer> checkedIndicators = new ArrayList<>();
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
					score = 5;
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
			break;
		case "Action":
			ActionService as = new ActionService();
			linkObj = as.find(Integer.parseInt(request.getParameter("linkObjectId")));
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
		case "Action":
			ActionService as = new ActionService();
			if(linkObj != null)
					target = as.getActionByMission(((Mission) linkObj).getId());
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