package com.example.music_management.controller;

import com.example.music_management.entity.Album;
import com.example.music_management.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import com.example.music_management.form.AlbumForm;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public String albums(Model model) {
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);
        return "album/album-list";
    }

    @GetMapping("/new")
    public String albumForm(Model model) {
        AlbumForm albumForm = new AlbumForm();
        model.addAttribute("albumForm", albumForm);
        return "album/album-form";
    }

    @PostMapping("/new")
    public String createAlbum(AlbumForm albumForm/*, Model model */) {
        albumService.createAlbum(albumForm);

        // List<Album> albums = albumService.getAllAlbums();
        // model.addAttribute("albums", albums);
        // return "album/album-list";
        return "redirect:/albums";
    }

    @GetMapping("/{albumId}")
    public String album(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);
        return "album/album-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }

    @GetMapping("/{albumId}/edit")
    public String editAlbum(@PathVariable long albumId, Model model) {
        Album album = albumService.getAlbumById(albumId);
        model.addAttribute("album", album);

        return "album/album-edit";
    }

    @PostMapping("/{albumId}/edit")
    public String updateAlbum(@PathVariable long albumId, Album album) {
        albumService.updateAlbum(albumId, album);
        return "redirect:/albums";
    }
}
