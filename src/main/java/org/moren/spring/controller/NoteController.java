package org.moren.spring.controller;

import javax.validation.Valid;

import org.moren.spring.domain.Note;
import org.moren.spring.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/notes")
public class NoteController {

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

		if (result.hasErrors()) {
			return "create";
		}
		
		noteService.save(note);
		return "redirect:/";
	}

	@PostMapping("delete")
	public String deleteNote(Integer id) {
		noteService.delete(id);
		System.out.println("delete id:" + id);
		return "redirect:/notes";
	}

	@PostMapping("edit")
	public String editNote(@ModelAttribute @Valid Note note, BindingResult result) {

		if(result.hasErrors()) {
			return "redirect:/";
		}
		
		System.out.println("Edit: " + note.toString());
		noteService.update(note);

		return "redirect:/";
	}

}
