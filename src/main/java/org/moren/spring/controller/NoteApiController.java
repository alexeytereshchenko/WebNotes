package org.moren.spring.controller;

import lombok.AllArgsConstructor;
import org.moren.spring.model.Note;
import org.moren.spring.model.User;
import org.moren.spring.service.NoteService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class NoteApiController {

	private final NoteService NoteService;

	@GetMapping("/all")
	public List<Note> api(@AuthenticationPrincipal User user) {
		return NoteService.getAll(user);
	}
	
	@GetMapping("{id}")
	public Optional<Note> apiById(@PathVariable Integer id,
								  @AuthenticationPrincipal @Valid User user) {
		return NoteService.getById(id, user);
	}
	
	@GetMapping({"title/{title}"})
	public List<Note> apiByTitle(@PathVariable String title,
								 @AuthenticationPrincipal @Valid User user) {
		return NoteService.getByTitle(title, user);
	}
	
	@GetMapping("description/{description}")
	public List<Note> apiByDescription(@PathVariable String description,
									   @AuthenticationPrincipal @Valid User user) {
		return NoteService.getByDescription(description, user);
	}

}
