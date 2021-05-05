package ru.netology.manager;

import ru.netology.domain.Movie;
import ru.netology.repository.AfishaRepository;

public class AfishaManager {
    private AfishaRepository repository;
    private int moviesAmountInFeed = 10;

    public AfishaManager(AfishaRepository repository) {
        this.repository = repository;
    }

    public AfishaManager(AfishaRepository repository, int moviesAmountInFeed) {
        this.repository = repository;
        this.moviesAmountInFeed = moviesAmountInFeed;
    }

    public void addToFeed(Movie movie) {
        repository.save(movie);
    }

    public Movie[] getMoviesFeed() {
        Movie[] movies = repository.findAll();
        int length = moviesAmountInFeed;
        if (moviesAmountInFeed > movies.length) {
            length = movies.length;
        }
        Movie[] result = new Movie[length];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }
}
