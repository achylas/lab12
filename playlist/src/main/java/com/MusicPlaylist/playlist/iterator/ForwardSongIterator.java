package com.MusicPlaylist.playlist.iterator;

import com.MusicPlaylist.playlist.model.Song;

import java.util.List;

public class ForwardSongIterator implements SongIterator {
    private final List<Song> songs;
    private int position = 0;

    public ForwardSongIterator(List<Song> songs) {
        this.songs = songs;
    }

    @Override
    public boolean hasNext() {
        return position < songs.size();
    }

    @Override
    public Song next() {
        return hasNext() ? songs.get(position++) : null;
    }
}