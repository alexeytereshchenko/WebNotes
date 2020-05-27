package org.moren.spring.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@Entity(name = "notes")
public class Note {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "Title must not be empty!")
    private String title;

    @NotBlank(message = "Description must not be empty!")
    private String description;

    @ManyToOne
    User user;
}
