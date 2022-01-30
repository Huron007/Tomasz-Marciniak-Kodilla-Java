package com.kodilla.rps;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class RpsTestSuite {

    @Test
    public void MachineChoiceTestSuite(){

        GameDifficulty difficulty = GameDifficulty.HARD;
        GameOption option = GameOption.SCISSORS;
        GameController controller = new GameController();
        controller.userChoice(option);

        GameOption machineChoice = controller.machineChoice(option, difficulty);
        Assertions.assertEquals(GameOption.class, option.getClass());
    }
}
