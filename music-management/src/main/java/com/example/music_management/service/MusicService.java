package com.example.music_management.service;
import com.example.music_management.entity.Album;
import com.example.music_management.entity.Music;
import com.example.music_management.form.MusicForm;
import com.example.music_management.repository.MusicRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class MusicService{
    private final MusicRepository musicRepository;
    public MusicService(MusicRepository musicRepository) {
        this.musicRepository =musicRepository;
    }
    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicRepository.getMusicsByAlbumId(albumId);
    }

    public void createMusic(MusicForm musicForm) {
        Music music = new Music();
        music.setTitle(musicForm.getTitle());
        music.setDuration(musicForm.getDuration());
        music.setReleaseDate(musicForm.getReleaseDate());
        music.setPlace(musicForm.getPlace());
        music.setAlbumId(musicForm.getAlbumId());
        musicRepository.insertMusic(music);
    }

    public void deleteMusic(long musicId) {
        musicRepository.deleteMusic(musicId);
    }

    public List<Music> getAllMusic() {
        return musicRepository.getAllMusics();
    }

    public List<Music> sortAlbumId_Musics() {
        return musicRepository.sortAlbumId_Musics();
    }

    public List<Music> sortDateAndTime_Musics() {
        return musicRepository.sortDateAndTime_Musics();
    }
}