package com.MusicPlaylist.playlist.core;

import com.MusicPlaylist.playlist.iterator.ForwardSongIterator;
import com.MusicPlaylist.playlist.iterator.ReverseSongIterator;
import com.MusicPlaylist.playlist.model.Song;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Song> songs;

    public Playlist() {
        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public List<Song> getSongs() {
        return songs;
    }

    public ForwardSongIterator getForwardIterator() {
        return new ForwardSongIterator(songs);
    }

    public ReverseSongIterator getReverseIterator() {
        return new ReverseSongIterator(songs);
    }
}