package org.moren.spring.service;

import java.util.List;
import java.util.Optional;

import org.moren.spring.domain.Note;

public interface NoteService {

	void save(Note note);
	void update(Note note);
	void delete(Integer id);
	List<Note> getAll();
	Optional<Note> getById(Integer id);
	List<Note> getByTitle(String title);
	List<Note> getByDescription(String description);

}
