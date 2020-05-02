package org.moren.spring.controller;

import java.util.List;
import java.util.Optional;

import org.moren.spring.domain.Note;
import org.moren.spring.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class NoteRestController {

	private NoteService NoteService;

	@Autowired
	public void setNoteService(org.moren.spring.service.NoteService noteService) {
		NoteService = noteService;
	}

	@GetMapping("/all")
	public List<Note> api() {
		return NoteService.getAll();
	}
	
	@GetMapping("{id}")
	public Optional<Note> apiById(@PathVariable Integer id) {
		return NoteService.getById(id);
	}
	
	@GetMapping({"title/{title}"})
	public List<Note> apiByTitle(@PathVariable String title) {
		return NoteService.getByTitle(title);
	}
	
	@GetMapping("description/{description}")
	public List<Note> apiByDescription(@PathVariable String description) {
		return NoteService.getByDescription(description);
	}

}
