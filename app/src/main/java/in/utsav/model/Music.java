package in.utsav.model;

/**
 * Created by hp on 19-07-16.
 */
public class Music {

    //properties

    String musicTitle;
    String musicSinger;
    String musicLyrics;
    int songId;
    int photoId;

    //constructor


    Music(String musicTitle, String musicLyrics, String musicSinger, int songId, int photoId){

        this.musicTitle = musicTitle;
        this.musicSinger = musicSinger;
        this.musicLyrics = musicLyrics;
        this.songId = songId;
        this.photoId = photoId;


    }

    //methods(getter & setter)
    public String getMusicTitle()
    {
        return musicTitle;
    }

    public void setMusicTitle(String musicTitle)
    {
        this.musicTitle = musicTitle;
    }

    public String getMusicLyrics()
    {
        return musicLyrics;
    }

    public void setMusicLyrics(String musicLyrics)
    {
        this.musicLyrics = musicLyrics;
    }

    public String getMusicSinger()
    {
        return musicSinger;
    }

    public void setMusicSinger(String musicSinger) {
        this.musicSinger = musicSinger;
    }

    public int getSongId()
    {
        return songId;
    }

    public void setSongId(int songId)
    {
        this.songId = songId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

}
