package com.example.spring_hm_6.entyties;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

/**
 * Класс заметки.
 * id -первичный ключ. Генерируется автоматически
 * title, discription - заголовок и описание, не могут быть null.
 * dateCreate - дата создания, генерируется при создании заметки
 */
@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class Note {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @NonNull
  private String title;
  @NonNull
  private String discription;
  @Column(name = "date_create")
  private LocalDateTime dateCreate;
  @Column(name = "date_update")
  private LocalDateTime dateUpdate;
}
