package com.kodilla.rps;

public enum GameOption {
    ROCK(1, new int[]{2, 5}, new int[]{3, 4}),
    PAPER(2, new int[]{3, 4}, new int[]{1, 5}),
    SCISSORS(3,new int[]{1, 5}, new int[]{2, 4}),
    LIZARD(4,new int[]{1, 3}, new int[]{2, 5}),
    SPOCK(5,new int[]{2, 4}, new int[]{1, 3}),
    DYNAMITE(6,new int[]{-2}, new int[]{-2}),
    EMPTY(-1, new int[]{-1}, new int[]{-1});

    private int id;
    private int[] getsBeatenBy;
    private int[] beats;

    GameOption(int id, int[] getsBeatenBy, int[] beats) {
        this.id = id;
        this.getsBeatenBy = getsBeatenBy;
        this.beats = beats;
    }

    public static GameOption valueOf(int userOption){
        for (GameOption option: GameOption.values()){
            if(userOption == option.id){
                return option;
            }
        }
        return EMPTY;
    }

    public int getId() {
        return id;
    }

    public int[] getGetsBeatenBy() {
        return getsBeatenBy;
    }

    public int[] getBeats() {
        return beats;
    }
}
