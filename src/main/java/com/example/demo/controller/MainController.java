package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.controller.model.Movie;
import com.example.demo.controller.model.Song;



@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String home(Model model) {

        model.addAttribute("nome", "Daniel");
        return "home";
    }
    
    Movie m1 = new Movie(1, "The Matrix");
    Movie m2 = new Movie(2, "Inception");
    Movie m3 = new Movie(3, "Interstellar");
    Movie m4 = new Movie(4, "The Truman Show");

    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(m1);
        movies.add(m2);
        movies.add(m3);
        movies.add(m4);
        return movies;
    }

    Song s1 = new Song(1, "Blinding Lights");
    Song s2 = new Song(2, "The Hills");
    Song s3 = new Song(3, "Congratulations");
    Song s4 = new Song(4, "Rockstar");

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
        songs.add(s1);
        songs.add(s2);
        songs.add(s3);
        songs.add(s4);
        return songs;
    }

    @GetMapping("/movies")
    public String movies(Model model) {
        List<Movie> bestMovies = getBestMovies();
        String titles = "";

        for (int i = 0; i < bestMovies.size(); i++) {
            titles += bestMovies.get(i).getTitolo();

            if (i < bestMovies.size() - 1){
                titles += ", ";
            }
        }

        model.addAttribute("titles", titles);
        return "movies";
    }

    @GetMapping("/songs")
    public String songs(Model model) {
        List<Song> bestSongs = getBestSongs();
        String titles = "";

        for (int i = 0; i < bestSongs.size(); i++) {
            titles += bestSongs.get(i).getTitolo();

            if (i < bestSongs.size() - 1){
                titles += ", ";
            }
        }

        model.addAttribute("titles", titles);
        return "songs";
    }
    
}
