package br.com.ps.webmyclient.cliente;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ps.webmyclient.generico.TipoPessoa;

@Controller
@RequestMapping("/cliente")
public class ClienteCadastroController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping("/cadastro")
	public ModelAndView index() {
		Cliente cliente = new Cliente();
		ModelAndView mav = new ModelAndView("/cliente/cadastro");
		mav.addObject("cliente", cliente);
		mav.addObject("pessoas", Arrays.asList(TipoPessoa.values()));
		return mav;
	}

	@PostMapping("/cadastro/salvar")
	public ModelAndView salvar(@Valid Cliente cliente) {
		ModelAndView mav = new ModelAndView("/cliente/cadastro");
		if(cliente != null) {
			Cliente clienteSalvar =  clienteService.salvar(cliente);
			if(clienteSalvar != null) {
				mav.setViewName("/cliente/lista");
			}
		}
		return mav;
	}

}