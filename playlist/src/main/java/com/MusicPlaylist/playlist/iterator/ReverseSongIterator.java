package com.MusicPlaylist.playlist.iterator;

import com.MusicPlaylist.playlist.model.Song;

import java.util.List;

public class ReverseSongIterator implements SongIterator {
    private final List<Song> songs;
    private int position;

    public ReverseSongIterator(List<Song> songs) {
        this.songs = songs;
        this.position = songs.size() - 1;
    }

    @Override
    public boolean hasNext() {
        return position >= 0;
    }

    @Override
    public Song next() {
        return hasNext() ? songs.get(position--) : null;
    }
}