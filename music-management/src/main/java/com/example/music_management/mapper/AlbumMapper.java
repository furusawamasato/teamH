package com.example.music_management.mapper;

import com.example.music_management.entity.Album;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AlbumMapper {
    
    @Select("SELECT * FROM albums")
    List<Album> selectAllAlbums();

    @Insert("INSERT INTO albums (title, artist, release_date) VALUES (#{title}, #{artist}, #{releaseDate})")
    @Options(useGeneratedKeys = true, keyProperty = "albumId")
    void insertAlbum(Album album);

    @Select("SELECT * FROM albums WHERE album_id = #{albumId}")
    Album selectAlbumById(long albumId);

    @Delete("DELETE FROM albums WHERE album_id = #{albumId}")
    void deleteAlbumById(long albumId);

    @Update("UPDATE albums SET title = #{title}, artist = #{artist}, release_date = #{releaseDate} WHERE album_id = #{albumId}")
    void updateAlbum(Album album);
}
