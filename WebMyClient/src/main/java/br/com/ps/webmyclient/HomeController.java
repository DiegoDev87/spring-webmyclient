package br.com.ps.webmyclient;

import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ps.webmyclient.enums.Sexo;
import br.com.ps.webmyclient.usuario.Usuario;

@Controller
@RequestMapping({"/","/home"})
public class HomeController {
	
	@GetMapping
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		Usuario usuario = new Usuario();
		mav.addObject("sexos", Arrays.asList(Sexo.values()));
		mav.addObject("usuario", usuario);
		return mav;
	}
}
