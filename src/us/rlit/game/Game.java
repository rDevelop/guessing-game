package us.rlit.game;


import us.rlit.client.Client;

import static java.lang.Math.random;

/**
 * Created by rob on 10/11/16.
 */
public class Game {

    private int guesses = 0;
    private int number = 0;
    private int direction = 0;
    private boolean gameOver = false;

    public static void main(String[] args) {
        new Client().client(new String[]{});
    }

    public boolean isGameOver() {
        return gameOver;
    }

    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    public int getGuesses() {
        return guesses;
    }

    public int getNumber() {
        return number;
    }

    public int getDirection() {
        return direction;
    }

    public void start() {
        guesses = 0;
        direction = 0;
        number = (int) ((random() * 100) + 1);
    }

    public boolean guess(int guess) {
        guesses++;
        if (guess == number) {
            return true;
        } else if (guess < number) {
            direction = -1;
        } else {
            direction = 1;
        }
        return false;
    }
}
