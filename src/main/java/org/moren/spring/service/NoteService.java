package org.moren.spring.service;

import org.moren.spring.model.Note;
import org.moren.spring.model.User;

import java.util.List;
import java.util.Optional;

public interface NoteService {

	void save(Note note, User user);
	void update(Note note, User user);
	void delete(Integer noteId, User user);
	List<Note> getAll(User user);
	Optional<Note> getById(Integer id, User user);
	List<Note> getByTitle(String title, User user);
	List<Note> getByDescription(String description, User user);
}
