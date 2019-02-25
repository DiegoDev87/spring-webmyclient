package br.com.ps.webmyclient.usuario;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ps.webmyclient.enums.Sexo;
import br.com.ps.webmyclient.exception.EmailExisteException;

@Controller
@RequestMapping("/usuario")
public class UsuarioCadastroController {

	@Autowired
	private UsuarioService usuarioService;

	@GetMapping("/cadastro")
	public ModelAndView cadastro() {
		ModelAndView mav = new ModelAndView("/usuario/cadastro");
		Usuario usuario = new Usuario();
		mav.addObject("sexos", Arrays.asList(Sexo.values()));
		mav.addObject("usuario", usuario);
		return mav;
	}

	@PostMapping("/cadastro/salvar")
	public ModelAndView salvar(@Valid Usuario usuario, BindingResult result) {
		ModelAndView mav = new ModelAndView("/usuario/cadastro");
		try {
			if (!result.hasErrors()) {
				usuarioService.salvar(usuario);
			}
		} catch (EmailExisteException e) {
			e.printStackTrace();
		}
		return mav;
	}

}
