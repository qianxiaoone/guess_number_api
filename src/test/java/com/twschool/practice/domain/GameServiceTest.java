package com.twschool.practice.domain;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;

public class GameServiceTest {
    @Test
    public void should_create_game_once_when_guess_incorrect_number_twice(){
        GameService gameService = new GameService();
        GameService spyGameService = Mockito.spy(gameService);

        RandomAnswerGenerator randomAnswerGenerator =Mockito.mock(RandomAnswerGenerator.class);
        Mockito.when(randomAnswerGenerator.generateAnswer()).thenReturn(new Answer(Arrays.asList("1","2","3","4")));
        Mockito.doReturn(new GuessNumberGame(randomAnswerGenerator)).when(spyGameService).createGuessNumberGame();
        spyGameService.guess("1 2 3 5");
        spyGameService.guess("1 2 3 5");
        Mockito.verify(spyGameService,Mockito.times(1)).createGuessNumberGame();

    }
}
