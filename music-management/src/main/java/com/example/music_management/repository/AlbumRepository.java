package com.example.music_management.repository;

import com.example.music_management.mapper.AlbumMapper;
import com.example.music_management.entity.Album;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AlbumRepository {
    private final AlbumMapper albumMapper;
    
    public AlbumRepository(AlbumMapper albumMapper) {
        this.albumMapper = albumMapper;
    }
    
    public List<Album> getAllAlbums() {
        return albumMapper.selectAllAlbums();
    }

    public void insertAlbum(Album album) {
        albumMapper.insertAlbum(album);
    }

    public Album getAlbumById(long albumId) {
        return albumMapper.selectAlbumById(albumId);
    }

    public void deleteAlbum(long albumId) {
        albumMapper.deleteAlbumById(albumId);
    }

    public void updateAlbum(Album album) {
        albumMapper.updateAlbum(album);
    }

    public List<Album> sortAlbumId_Albums() {
        return albumMapper.sortAlbumId_Albums();
    }

    public List<Album> sortTitleASC_Albums() {
        return albumMapper.sortTitleASC_Albums();
    }

    public List<Album> searchTitle(String search_Title) {
        return albumMapper.searchTitle(search_Title);
    }
}
