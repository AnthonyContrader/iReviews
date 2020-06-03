package it.contrader.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import it.contrader.dto.LocalitaDTO;
import it.contrader.service.LocalitaService;

@Controller
@RequestMapping("/localita")
public class LocalitaController {

	@Autowired
	private LocalitaService service;


	@GetMapping("/getall")
	public String getAll(HttpServletRequest request) {
		setAll(request);
		return "localitas";
	}

	@GetMapping("/delete")
	public String delete(HttpServletRequest request, @RequestParam("id") Long id) {
		service.delete(id);
		setAll(request);
		return "localitas";
	}

	@GetMapping("/preupdate")
	public String preUpdate(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "updatelocalita";
	}

	@PostMapping("/update")
	public String update(HttpServletRequest request, @RequestParam("id") Long id, @RequestParam("citta") String citta,
			@RequestParam("provincia") String provincia, @RequestParam("stato") String stato) {

		LocalitaDTO dto = new LocalitaDTO();
		dto.setId(id);
		dto.setCitta(citta);
		dto.setProvincia(provincia);
		dto.setStato(stato);
		service.update(dto);
		setAll(request);
		return "localitas";

	}

	@PostMapping("/insert")
	public String insert(HttpServletRequest request, @RequestParam("citta") String citta,
			@RequestParam("provincia") String provincia, @RequestParam("stato") String stato) {
		LocalitaDTO dto = new LocalitaDTO();
		dto.setCitta(citta);
		dto.setProvincia(provincia);
		dto.setStato(stato);
		service.insert(dto);
		setAll(request);
		return "localitas";
	}

	@GetMapping("/read")
	public String read(HttpServletRequest request, @RequestParam("id") Long id) {
		request.getSession().setAttribute("dto", service.read(id));
		return "readlocalita";
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
