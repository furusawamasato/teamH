package com.example.music_management.controller;

import com.example.music_management.entity.Album;
import com.example.music_management.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import com.example.music_management.form.AlbumForm;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.music_management.entity.Music;
import com.example.music_management.service.MusicService;
import com.example.music_management.form.MusicForm;

//test

@Controller
@RequestMapping("/albums")
public class AlbumController {
    private final AlbumService albumService;
    private final MusicService musicService;

    public AlbumController(AlbumService albumService, MusicService musicService) {
        this.albumService = albumService;
        this.musicService = musicService;
    }

    @GetMapping
    public String albums(Model model) {
        List<Album> albums = albumService.getAllAlbums();
        model.addAttribute("albums", albums);

        List<Music> musics = musicService.getAllMusic();
        Map<Long, Music> map = new HashMap<>();
        for (Music music : musics) {
            if (map.get(music.getAlbumId()) == null) {
                map.put(music.getAlbumId(), music);
            }

            else if (map.get(music.getAlbumId()).getReleaseDate().compareTo(music.getReleaseDate()) < 0) {
                map.put(music.getAlbumId(), music);
            }

            else if (map.get(music.getAlbumId()).getReleaseDate().compareTo(music.getReleaseDate()) == 0) {
                if (map.get(music.getAlbumId()).getDuration().compareTo(music.getDuration()) < 0) {
                    map.put(music.getAlbumId(), music);
                }
            }
        }

        musics = new ArrayList<>(map.values());

        model.addAttribute("musics", musics);
        return "album/album-list";
    }

    @GetMapping("/sortAlbumId")
    public String sortAlbumId(Model model) {
        List<Album> sortAlbumId_Albums = albumService.sortAlbumId_Albums();
        model.addAttribute("sortAlbumId_Albums", sortAlbumId_Albums);

        List<Music> sortAlbumId_Musics = musicService.sortAlbumId_Musics();

        Map<Long, Music> map = new LinkedHashMap<>();
        for (Music music : sortAlbumId_Musics) {
            if (map.get(music.getAlbumId()) == null) {
                map.put(music.getAlbumId(), music);
            }

            else if (map.get(music.getAlbumId()).getReleaseDate().compareTo(music.getReleaseDate()) < 0) {
                map.put(music.getAlbumId(), music);
            }

            else if (map.get(music.getAlbumId()).getReleaseDate().compareTo(music.getReleaseDate()) == 0) {
                if (map.get(music.getAlbumId()).getDuration().compareTo(music.getDuration()) < 0) {
                    map.put(music.getAlbumId(), music);
                }
            }
        }

        sortAlbumId_Musics = new ArrayList<>(map.values());

        model.addAttribute("sortAlbumId_Musics", sortAlbumId_Musics);
        return "album/album-sortAlbumId";
    }

    @GetMapping("/sortDateAndTime")
    public String sortDateAndTime(Model model) {
        List<Music> sortDateAndTime_Musics = musicService.sortDateAndTime_Musics();

        Map<Long, Music> map = new LinkedHashMap<>();
        for (Music music : sortDateAndTime_Musics) {
            if (map.get(music.getAlbumId()) == null) {
                map.put(music.getAlbumId(), music);
            }

            else if (map.get(music.getAlbumId()).getReleaseDate().compareTo(music.getReleaseDate()) < 0) {
                map.put(music.getAlbumId(), music);
            }

            else if (map.get(music.getAlbumId()).getReleaseDate().compareTo(music.getReleaseDate()) == 0) {
                if (map.get(music.getAlbumId()).getDuration().compareTo(music.getDuration()) < 0) {
                    map.put(music.getAlbumId(), music);
                }
            }
        }

        sortDateAndTime_Musics = new ArrayList<>(map.values());

        model.addAttribute("sortDateAndTime_Musics", sortDateAndTime_Musics);
        return "album/album-sortDateAndTime";
    }

    @GetMapping("/sortTitle")
    public String sortTitleASC_Albums(Model model) {
        List<Album> sortTitleASC_Albums = albumService.sortTitleASC_Albums();
        model.addAttribute("sortTitleASC_Albums", sortTitleASC_Albums);
        return "album/album-sortTitle";
    }

    @GetMapping("/searchTitle/{search_title}")
    public String searchTitle(@PathVariable String search_title, Model model) {
        List<Album> searchTitle = albumService.searchTitle(search_title);
        model.addAttribute("searchTitle", searchTitle);
        return "album/album-searchTitle";
    }
    
    // @GetMapping
    // public String musics(Model model) {
    //     List<Music> musics = musicService.getAllMusic();
    //     model.addAttribute("musics", musics);
    //     return "album/album-list";
    // }

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

        List<Music> musics = musicService.getMusicsByAlbumId(albumId);
        model.addAttribute("musics", musics);
        return "album/album-detail";
    }

    @PostMapping("/{albumId}/delete")
    public String deleteAlbum(@PathVariable long albumId) {
        albumService.deleteAlbum(albumId);
        return "redirect:/albums";
    }

    @PostMapping("/{albumId}/musics/{musicId}/delete")
    public String deleteMusic(@PathVariable long albumId, @PathVariable long musicId) {
        musicService.deleteMusic(musicId);
        return "redirect:/albums/" + albumId;
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

    @GetMapping("/{albumId}/musics/new")
    public String createMusicForm(@PathVariable long albumId, Model model) {
        MusicForm musicForm = new MusicForm();
        musicForm.setAlbumId(albumId);
        model.addAttribute("musicForm", musicForm);
        return "music/music-form";
    }
    @PostMapping("/{albumId}/musics/new")
        public String createMusic(@PathVariable long albumId, MusicForm musicForm) {
        musicService.createMusic(musicForm);
        return "redirect:/albums/" + albumId;
    }
}
