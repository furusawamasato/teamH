package com.example.music_management.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

@Data
public class Music{
    private long musicId;
    private String title;
    private LocalTime duration;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private String place;
    private long albumId;
    private LocalDateTime createdAt;
}
