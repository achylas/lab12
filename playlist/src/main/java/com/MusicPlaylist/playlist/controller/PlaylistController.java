package com.MusicPlaylist.playlist.controller;

import com.MusicPlaylist.playlist.core.Playlist;
import com.MusicPlaylist.playlist.iterator.ForwardSongIterator;
import com.MusicPlaylist.playlist.iterator.ReverseSongIterator;
import com.MusicPlaylist.playlist.model.Song;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {

    private final Playlist playlist = new Playlist();
    private final List<Song> forwardBuffer = new ArrayList<>();
    private final List<Song> reverseBuffer = new ArrayList<>();
    private ForwardSongIterator forwardIterator;
    private ReverseSongIterator reverseIterator;

    public PlaylistController() {
        playlist.addSong(new Song("Bohemian Rhapsody", "Queen"));
        playlist.addSong(new Song("Imagine", "John Lennon"));
        playlist.addSong(new Song("Hotel California", "Eagles"));
        playlist.addSong(new Song("Hey Jude", "The Beatles"));

        forwardIterator = playlist.getForwardIterator();
        reverseIterator = playlist.getReverseIterator();
    }

    @PostMapping("/add")
    public String addSong(@RequestParam String title, @RequestParam String artist) {
        playlist.addSong(new Song(title, artist));
        forwardIterator = playlist.getForwardIterator();
        reverseIterator = playlist.getReverseIterator();
        return "Added: " + title + " by " + artist;
    }

    @GetMapping("/next")
    public String playNext() {
        if (forwardIterator.hasNext()) {
            Song song = forwardIterator.next();
            forwardBuffer.add(song);
            return "▶ Now Playing: " + song;
        }
        return "🎵 End of playlist.";
    }

    @GetMapping("/prev")
    public String playPrevious() {
        if (reverseIterator.hasNext()) {
            Song song = reverseIterator.next();
            reverseBuffer.add(song);
            return "◀ Rewinding: " + song;
        }
        return "🛑 Start of playlist.";
    }

    @GetMapping("/list")
    public List<String> allSongs() {
        List<String> result = new ArrayList<>();
        for (Song song : playlist.getSongs()) {
            result.add(song.toString());
        }
        return result;
    }
}