package org.moren.spring.repository;

import org.moren.spring.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

	List<Note> findByDescriptionContainingIgnoreCase(String description);
	List<Note> findByTitleContainingIgnoreCase(String title);
	List<Note> findByUserId(Integer user_id);

}
