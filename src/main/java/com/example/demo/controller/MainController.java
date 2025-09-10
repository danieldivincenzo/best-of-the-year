package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.controller.model.Movie;
import com.example.demo.controller.model.Song;


@Controller
@RequestMapping("/")
public class MainController {

    @GetMapping("/")
    public String home(@RequestParam(required=false) String nome, Model model) {

        model.addAttribute("nome", nome);
        return "home";
    }
    
    private List<Movie> getBestMovies(){
        List<Movie> movies = new ArrayList<>();
        return movies;
    }

    private List<Song> getBestSongs(){
        List<Song> songs = new ArrayList<>();
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
