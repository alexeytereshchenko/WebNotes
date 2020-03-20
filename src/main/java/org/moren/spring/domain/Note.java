package org.moren.spring.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(schema = "notes")
public class Note {

	@Id
	@GeneratedValue
	private Integer id;

	@NotBlank(message = "Title must not be empty!")
	private String title;

	@NotBlank(message = "Description must not be empty!")
	private String description;

}
