package com.example.bcaparlar.stringfrequency;

public class FreqVal {
    char aChar;
    int freq;

    public FreqVal(char aChar, int freq) {
        this.aChar = aChar;
        this.freq = freq;
    }

    public void increaseFrequency() {
        this.freq += 1;
    }
}
