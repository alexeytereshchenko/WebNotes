package org.moren.spring.service;

import org.moren.spring.model.Note;
import org.moren.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface NoteService {

	void save(Note note, User user);
	void update(Note note, User user);
	void delete(Integer noteId);
	List<Note> getAll(User user);
	Optional<Note> getById(Integer id);
	List<Note> getByTitle(String title);
	List<Note> getByDescription(String description);

}
