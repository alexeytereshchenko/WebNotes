package org.moren.spring.controller;

import lombok.AllArgsConstructor;
import org.moren.spring.model.Note;
import org.moren.spring.model.User;
import org.moren.spring.service.NoteService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/notes")
@AllArgsConstructor
public class NoteController {

	private final NoteService noteService;

	@GetMapping
	public String getNotes(@AuthenticationPrincipal User user,
						   @RequestParam(defaultValue = "") String search,
						   Model model) {
		model.addAttribute("note", new Note());

		if (search.equals("")) {
			model.addAttribute("notes", noteService.getAll(user));
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
	public String createNote(@AuthenticationPrincipal User user,
							 @ModelAttribute @Valid Note note,
							 BindingResult result,
							 Model model) {
		if(result.hasErrors()) {
			return "create";
		}

		noteService.save(note, user);
		return "redirect:/";
	}

	@PostMapping("delete")
	public String deleteNote(Integer id) {
		noteService.delete(id);
		return "redirect:/notes";
	}

	@PostMapping("edit")
	public String editNote(@AuthenticationPrincipal User user,
						   @ModelAttribute @Valid Note note,
						   BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/";
		}

		noteService.update(note, user);
		return "redirect:/";
	}

}
