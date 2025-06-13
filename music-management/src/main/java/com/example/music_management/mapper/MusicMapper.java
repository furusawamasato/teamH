package com.example.music_management.mapper;
import com.example.music_management.entity.Album;
import com.example.music_management.entity.Music;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import java.util.List;
@Mapper
public interface MusicMapper{
    @Select("SELECT * FROM musics WHERE album_id = #{albumId}")
    List<Music> selectMusicsById(long album_id);
    @Insert("INSERT INTO musics (title, duration, release_Date, place, album_id) VALUES (#{title}, #{duration}, #{releaseDate}, #{place}, #{albumId})")
    @Options(useGeneratedKeys=true, keyProperty="musicId")
    void insertMusic(Music music);

    @Delete("DELETE FROM musics WHERE music_id = #{musicId}")
    void deleteMusicById(long musicId);

    @Select("SELECT * FROM musics ORDER BY release_Date DESC")
    List<Music> selectAllMusics();

    @Select("SELECT * FROM musics ORDER BY album_id DESC")
    List<Music> sortAlbumId_Musics();

    @Select("SELECT * FROM musics ORDER BY release_Date DESC")
    List<Music> sortDateAndTime_Musics();

}
