package org.moren.spring.controller;

import javax.validation.Valid;

import org.moren.spring.domain.Note;
import org.moren.spring.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

	private Logger log = LoggerFactory.getLogger(NoteController.class);
	
	@Autowired
	private NoteService noteService;

	@GetMapping
	public String Getnotes(@RequestParam(defaultValue = "") String search, Model model) {

		model.addAttribute("note", new Note());

		if (search.equals("")) {
			model.addAttribute("notes", noteService.getAll());
		} else {
			model.addAttribute("notes", noteService.getByTitle(search));
		}

		return "notes";
	}

	@GetMapping("create")
	public String getCreateNote(Model model) {
		model.addAttribute("note", new Note());
		return "create";
	}

	@PostMapping("create")
	public String createNote(@ModelAttribute @Valid Note note, BindingResult result, Model model) {

		if(result.hasErrors()) {
			log.warn("Can't save, note has white space or null {}", note);
			return "create";
		}
		
		noteService.save(note);
		log.info("Save {}", note);
		
		return "redirect:/";
	}

	@PostMapping("delete")
	public String deleteNote(Integer id) {
		
		log.info("Delete {}", noteService.getById(id));
		
		noteService.delete(id);
		
		return "redirect:/notes";
	}

	@PostMapping("edit")
	public String editNote(@ModelAttribute @Valid Note note, BindingResult result) {

		if(result.hasErrors()) {
			log.warn("Can't update, note has white space or null {}", note);
			return "redirect:/";
		}
		
		log.info("Update {} to {}", noteService.getById(note.getId()), note);
 
		noteService.update(note);

		return "redirect:/";
	}

}
