package br.com.ps.webmyclient.usuario;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ps.webmyclient.exception.EmailExisteException;

@Controller
@RequestMapping("/usuario")
public class UsuarioCadastroController {

	@Autowired
	private UsuarioService usuarioService;

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
