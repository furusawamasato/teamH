package com.example.music_management.repository;
import com.example.music_management.entity.Album;
import com.example.music_management.entity.Music;
import com.example.music_management.mapper.MusicMapper;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
public class MusicRepository{
    private final MusicMapper musicMapper;
    public MusicRepository(MusicMapper musicMapper) {
        this.musicMapper =musicMapper;
    }
    public List<Music> getMusicsByAlbumId(long albumId) {
        return musicMapper.selectMusicsById(albumId);
    }
    public void insertMusic(Music music) {
        musicMapper.insertMusic(music);
    }
    public void deleteMusic(long musicId) {
        musicMapper.deleteMusicById(musicId);
    }

    public List<Music> getAllMusics() {
        return musicMapper.selectAllMusics();
    }

    public List<Music> sortAlbumId_Musics() {
        return musicMapper.sortAlbumId_Musics();
    }

    public List<Music> sortDateAndTime_Musics() {
        return musicMapper.sortDateAndTime_Musics();
    }
}
