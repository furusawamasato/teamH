package com.example.music_management.form;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
@Data
public class MusicForm{
private String title;
private LocalTime duration;
@DateTimeFormat(pattern = "yyyy-MM-dd")
private LocalDate releaseDate;
private String place;
private long albumId;
}
