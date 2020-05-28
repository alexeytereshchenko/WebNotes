package org.moren.spring.repository;

import org.moren.spring.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

	List<Note> findByDescriptionContainingIgnoreCaseAndUserId(String description, Integer user_id);
	List<Note> findByTitleContainingIgnoreCaseAndUserId(String title, Integer user_id);
	List<Note> findByUserId(Integer user_id);
	Optional<Note> findByUserIdAndId(Integer user_id, Integer id);
}
