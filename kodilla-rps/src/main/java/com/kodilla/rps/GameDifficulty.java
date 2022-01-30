package com.kodilla.rps;

public enum GameDifficulty {
    EASY(1),
    MEDIUM(2),
    HARD(3);

    private int id;

     GameDifficulty(int id) {
        this.id = id;
    }

    public static GameDifficulty valueOf(int difficulty){
        for(GameDifficulty dif : GameDifficulty.values()){
            if(difficulty == dif.id){
                return dif;
            }
        }
        return EASY;
    }
}
