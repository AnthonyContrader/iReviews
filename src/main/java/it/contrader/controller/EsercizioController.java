package it.contrader.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.contrader.dto.EsercizioDTO;

@RestController
@RequestMapping("/esercizio")
@CrossOrigin(origins = "http://localhost:4200")
public class EsercizioController extends AbstractController<EsercizioDTO> {

}
