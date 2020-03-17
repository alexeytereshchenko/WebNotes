package org.moren.spring.service.imp;

import java.util.List;
import java.util.Optional;

import org.moren.spring.domain.Note;
import org.moren.spring.repository.NoteRepository;
import org.moren.spring.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteServiceImpl implements NoteService {

	@Autowired
	private NoteRepository noteRepository;
	
	@Override
	public void save(Note note) {
		noteRepository.save(note);
	}

	@Override
	public void update(Note note) {
		noteRepository.save(note);
	}

	@Override
	public void delete(Integer id) {
		noteRepository.deleteById(id);
	}

	@Override
	public List<Note> getAll() {
		return noteRepository.findByOrderByIdDesc();
	}

	@Override
	public List<Note> getByTitle(String title) {
		return noteRepository.findByTitleContainingIgnoreCase(title);
	}

	@Override
	public List<Note> getByDescription(String description) {
		return noteRepository.findByDescriptionContainingIgnoreCase(description);
	}

	@Override
	public Optional<Note> getById(Integer id) {
		return noteRepository.findById(id);
	}

}