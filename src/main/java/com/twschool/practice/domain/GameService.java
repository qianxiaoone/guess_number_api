package com.twschool.practice.domain;

import java.util.Arrays;
import java.util.List;

public class GameService {
    private GuessNumberGame guessNumberGame;

    public GameService(GuessNumberGame guessNumberGame) {
        this.guessNumberGame = guessNumberGame;
    }

    public GameService() {

    }

    public String guess(String userAnswerString) {
        List<String> userAnswer = Arrays.asList(userAnswerString.split(" "));
        GuessNumberGame guessNumberGame = getGame();
        return guessNumberGame.guess(userAnswer);
    }

    public GuessNumberGame getGame() {
        if (guessNumberGame == null) {
            guessNumberGame = createGuessNumberGame();
        }
        return guessNumberGame;
    }

    public GuessNumberGame createGuessNumberGame() {
        return new GuessNumberGame(new RandomAnswerGenerator());
    }
}
