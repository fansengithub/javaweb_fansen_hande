package com.hand.entity;

/**
 * Created by fansen on 2017/8/15.
 */
public class Film {
    private  int filmId;
    private  String  title;
    private  String descrip;
    private  int langId;
    private  String langug;

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    public String getLangug() {
        return langug;
    }

    public void setLangug(String langug) {
        this.langug = langug;
    }

    @Override
    public String toString() {
        return "Film{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", descrip='" + descrip + '\'' +
                ", langId=" + langId +
                ", langug='" + langug + '\'' +
                '}';
    }
}
