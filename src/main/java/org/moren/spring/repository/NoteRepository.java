package org.moren.spring.repository;

import java.util.List;

import org.moren.spring.domain.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, Integer>{

	List<Note> findByDescriptionContainingIgnoreCase(String description);
	List<Note> findByTitleContainingIgnoreCase(String title);
	List<Note> findByOrderByIdDesc();
}
