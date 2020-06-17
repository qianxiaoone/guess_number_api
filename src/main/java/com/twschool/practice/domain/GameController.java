package com.twschool.practice.domain;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class GameController {

    @GetMapping("/game")
    public Map<String, String> guess(@RequestParam String guess) {
        Map<String, String> map = new HashMap<String, String>();
        GuessNumberGame guessNumberGame = new GuessNumberGame(new RandomAnswerGenerator());
        String result = guessNumberGame.guess(Arrays.asList(guess.split(" ")));
        map.put("input", guess);
        map.put("result", result);
        return map;
    }

}
