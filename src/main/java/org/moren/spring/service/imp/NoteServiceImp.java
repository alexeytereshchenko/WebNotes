package org.moren.spring.service.imp;

import lombok.AllArgsConstructor;
import org.moren.spring.model.Note;
import org.moren.spring.model.User;
import org.moren.spring.repository.NoteRepository;
import org.moren.spring.service.NoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class NoteServiceImp implements NoteService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private final NoteRepository noteRepository;

    @Override
    public void save(Note note, User user) {
        note.setUser(user);
        log.debug("Save {}", note);
        noteRepository.save(note);
    }

    @Override
    public void update(Note note, User user) {
        note.setUser(user);
        log.debug("Update {}", note);
        noteRepository.save(note);
    }

    @Override
    public void delete(Integer noteId, User user) {
        log.debug("Delete {}", noteRepository.findById(noteId).get());
        Note note = noteRepository.findByUserIdAndId(user.getId(), noteId).get();
        noteRepository.delete(note);
    }

    @Override
    public List<Note> getAll(User user) {
        return noteRepository.findByUserId(user.getId())
                .stream()
                .sorted((note1, note2) -> note2.getId().compareTo(note1.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public List<Note> getByTitle(String title, User user) {
        return noteRepository.findByTitleContainingIgnoreCaseAndUserId(title, user.getId());
    }

    @Override
    public List<Note> getByDescription(String description, User user) {
        return noteRepository.findByDescriptionContainingIgnoreCaseAndUserId(description, user.getId());
    }

    @Override
    public Optional<Note> getById(Integer id, User user) {
        return noteRepository.findById(id);
    }

}