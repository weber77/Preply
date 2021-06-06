package fr.soro.restcontroller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.soro.Client.EmpruntClient;
import fr.soro.Client.OuvrageClient;
import fr.soro.dto.EmpruntDto;
import fr.soro.dto.OuvrageDto;
import fr.soro.dto.UserDto;

@RestController
public class EmpruntController {
	
	private EmpruntClient empruntService;
	
	
	public EmpruntController(EmpruntClient empruntService) {
		this.empruntService = empruntService;
	}

	@GetMapping("/user-emprunts/{id}")
	public ModelAndView getUserEmprunts(@PathVariable(value = "id") Long id,ModelAndView modelAndView){		
		List<EmpruntDto> emprunts = empruntService.getUserEmprunts(id);		
		modelAndView.addObject("emprunts", emprunts);
		modelAndView.setViewName("user-emprunts");
		return modelAndView;
		
	}
	
	@GetMapping("/user/prolonger/emprunts/{id}")
	public ModelAndView getProlongation(@PathVariable(value = "id") Long id,HttpSession session){		
		this.empruntService.getProlongation(id);
		UserDto user =(UserDto) session.getAttribute("userSession");
//		List<EmpruntDto> emprunts = empruntService.getUserEmprunts(user.getId());	
//		modelAndView.addObject("emprunts", emprunts);
		ModelAndView modelAndView = new ModelAndView("redirect:/user-emprunts/"+user.getId());
		return modelAndView;
		
	}
}
