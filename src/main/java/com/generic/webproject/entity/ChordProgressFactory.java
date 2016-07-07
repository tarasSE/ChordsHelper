package com.generic.webproject.entity;

public class ChordProgressFactory {
    public static ChordProgress getInstance(ChordProgress.ChordProgressEnum progressEnum, Chord chord){
        ChordProgress progress = new ChordProgress();
        progress.setChord(chord);
        progress.setProgress(progressEnum);
        return progress;
    }
}
