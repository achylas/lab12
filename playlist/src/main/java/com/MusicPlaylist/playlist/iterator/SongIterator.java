package com.MusicPlaylist.playlist.iterator;

import com.MusicPlaylist.playlist.model.Song;

public interface SongIterator {
    boolean hasNext();
    Song next();
}
