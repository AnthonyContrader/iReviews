package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import it.contrader.dto.TipologiaDTO;
import it.contrader.model.Tipologia;
import it.contrader.service.TipologiaService;

@Controller
@RequestMapping("/tipologia")
public class TipologiaController {

	@Autowired
	private TipologiaService service;

	/*
	@PostMapping("/login")
	public String login(HttpServletRequest request, @RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password) {

		UserDTO userDTO = service.findByUsernameAndPassword(username, password);
		request.getSession().setAttribute("user", userDTO);

		switch (userDTO.getUsertype()) {

		case ADMIN:
			return "homeadmin";

		case USER:
			return "index";

		default:
			return "index";
		}
	}*/

	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "tipologias";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "tipologias";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatetipologia";
	}
	
	
	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") long id, @RequestParam("tipologia") String tipologia) {
		TipologiaDTO dto = new TipologiaDTO();		
		dto.setId(id);
		dto.setTipologia(tipologia);			
		service.update(dto);
		setAll(request);
		return "tipologias";
	} 

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("tipologia") String tipologia) {
		TipologiaDTO dto = new TipologiaDTO();
		dto.setTipologia(tipologia);
		service.insert(dto);
		setAll(request);
		return "tipologias";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readtipologia";
	}

	@GetMapping("/logout")
	public String logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return "index";
	}

	private void setAll(HttpServletRequest request) {
		request.getSession().setAttribute("list", service.getAll());
	}
}
