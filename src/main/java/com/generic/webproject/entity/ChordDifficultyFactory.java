package com.generic.webproject.entity;

public class ChordDifficultyFactory {
    public static ChordDifficulty getInstance(ChordDifficulty.ChordDifficultyEnum difficultyEnum, Chord chord){
        ChordDifficulty difficulty = new ChordDifficulty();
        difficulty.setChord(chord);
        difficulty.setDifficulty(difficultyEnum);
        return difficulty;
    }
}
