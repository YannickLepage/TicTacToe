package kreu.morpion;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Random;

/**
 * Created by ylepage on 28/04/15.
 */
public class Utils {

    /**
     * @param buttons
     * @return
     */

    public static boolean won(Button[] buttons) {
       if ((String.valueOf(buttons[0].getText()).matches("X")) || ((String.valueOf(buttons[0].getText()).matches("O")))){
            if ((String.valueOf(buttons[0].getText()).matches(String.valueOf(buttons[1].getText())))
                    &&
                    (String.valueOf(buttons[0].getText()).matches(String.valueOf(buttons[2].getText())))) {
                Log.d("won", "true");
                return true;
            }if ((String.valueOf(buttons[0].getText()).matches(String.valueOf(buttons[3].getText())))
                    &&
                   (String.valueOf(buttons[0].getText()).matches(String.valueOf(buttons[6].getText())))){
                Log.d("won", "true");
                return true;
            }if ((String.valueOf(buttons[0].getText()).matches(String.valueOf(buttons[4].getText())))
                    &&
                    (String.valueOf(buttons[0].getText()).matches(String.valueOf(buttons[8].getText())))) {
                Log.d("won", "true");
                return true;
            }
        }
        if  ((String.valueOf(buttons[1].getText()).matches("X")) || ((String.valueOf(buttons[1].getText()).matches("O")))){
            if ((String.valueOf(buttons[1].getText()).matches(String.valueOf(buttons[4].getText())))
                    &&
                    (String.valueOf(buttons[1].getText()).matches(String.valueOf(buttons[7].getText())))) {
                Log.d("won", "true");
                return true;
            }
        }
        if  ((String.valueOf(buttons[2].getText()).matches("X")) || ((String.valueOf(buttons[2].getText()).matches("O")))){
            if ((String.valueOf(buttons[2].getText()).matches(String.valueOf(buttons[5].getText())))
                    &&
                    (String.valueOf(buttons[2].getText()).matches(String.valueOf(buttons[8].getText())))) {
                Log.d("won", "true");
                return true;
            }if ((String.valueOf(buttons[2].getText()).matches(String.valueOf(buttons[4].getText())))
                    &&
                    (String.valueOf(buttons[2].getText()).matches(String.valueOf(buttons[6].getText())))) {
                Log.d("won", "true");
                return true;
            }
        }
        if  ((String.valueOf(buttons[3].getText()).matches("X")) || ((String.valueOf(buttons[3].getText()).matches("O")))) {
            if ((String.valueOf(buttons[3].getText()).matches(String.valueOf(buttons[4].getText())))
                    &&
                    (String.valueOf(buttons[3].getText()).matches(String.valueOf(buttons[5].getText())))) {
                Log.d("won", "true");
                return true;
            }
        }
        if  ((String.valueOf(buttons[6].getText()).matches("X")) || ((String.valueOf(buttons[6].getText()).matches("O")))){
            if ((String.valueOf(buttons[6].getText()).matches(String.valueOf(buttons[7].getText())))
                    &&
                    (String.valueOf(buttons[6].getText()).matches(String.valueOf(buttons[8].getText())))) {
                Log.d("won", "true");
                return true;
            }
        }

        return false;
    }

    public static boolean even(Button[] buttons) {
        if (((String.valueOf(buttons[0].getText()).matches("X")) || ((String.valueOf(buttons[0].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[1].getText()).matches("X")) || ((String.valueOf(buttons[1].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[2].getText()).matches("X")) || ((String.valueOf(buttons[2].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[3].getText()).matches("X")) || ((String.valueOf(buttons[3].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[4].getText()).matches("X")) || ((String.valueOf(buttons[4].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[5].getText()).matches("X")) || ((String.valueOf(buttons[5].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[6].getText()).matches("X")) || ((String.valueOf(buttons[6].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[7].getText()).matches("X")) || ((String.valueOf(buttons[7].getText()).matches("O"))))
                &&
                ((String.valueOf(buttons[8].getText()).matches("X")) || ((String.valueOf(buttons[8].getText()).matches("O"))))) {
                        return true;
        }
        return false;
    }


    /**
     * @param buttons
     * @return tableau d'int représentant l'etat de chaque bouton :
     * 0 pour non coché, 1 pour coché
     */
    public static int[] getButtonState(Button[] buttons) {

        int[] bool = new int[9];
        for (int loop = 0; loop < 9; loop++) {
            if (buttons[loop].getText().toString().matches("")) {
                bool[loop] = 0;
            } else if (buttons[loop].getText().toString().matches("O")) {
                bool[loop] = 1;
            }else{
                bool[loop] = 2;
            }
        }

        return bool;
    }

    /**
     * @param buttons Passes tous les buttons sans text au statut enabled au lancement de la fonction
     */
    public static void enable(Button[] buttons) {
        int[] buttonState = Utils.getButtonState(buttons);
        for (int loop = 0; loop < 9; loop++) {
            if (buttonState[loop] == 0) {
                buttons[loop].setEnabled(true);
            }
        }
    }

    /**
     *
     * @param buttons
     * Desactive tous les boutons.
     */
    public static void disable(Button[] buttons) {
        for (int loop = 0; loop < 9; loop++) {
                buttons[loop].setEnabled(false);
        }
    }

    /**
     * @param compteur
     * @return int, le joueur dont c'est actuellement le tour de jouer
     */
    public static int getPlayer(int compteur) {
        int player;
        if (compteur % 2 == 0) {
            player = 2;
        } else {
            player = 1;
        }
        return player;
    }

    /**
     *
     * @param view
     * @param player
     * @param buttons
     * Lors du click sur un bouton vérifie quel joueur joue et change le texte du
     * bouton en conséquence via la méthode play.
     * dans le cas d'une partie contre l'ordinateur le compteur est doublé et le
     * joueur 2 est ignoré.
     */
    public static void check(View view, int player, Button[] buttons){
        switch (view.getId()){
            case (R.id.button_0):
                Utils.play(buttons[0], player);
                break;

            case (R.id.button_1):
                Utils.play(buttons[1], player);
                break;
            case (R.id.button_2):
                Utils.play(buttons[2], player);
                break;

            case (R.id.button_3):
                Utils.play(buttons[3], player);
                break;

            case (R.id.button_4):
                Utils.play(buttons[4], player);
                break;

            case (R.id.button_5):
                Utils.play(buttons[5], player);
                break;

            case (R.id.button_6):
                Utils.play(buttons[6], player);
                break;

            case (R.id.button_7):
                Utils.play(buttons[7], player);
                break;

            case (R.id.button_8):
                Utils.play(buttons[8], player);
                break;
        }
    }

    /**
     *
     * @param button
     * @param player
     * change le text d'un bouton a O ou X en fonction du joueur qui a cliqué
     */
    public  static void play(Button button, int player){
        if(player == 1) {
            button.setText(R.string.circle);
        }else{
            button.setText(R.string.cross);
        }
        button.setEnabled(false);
    }

    /**
     *if two buttons are played by player, the computer put a cross to block the line
     */
    public static void computerPlays(Button[] buttons) {
        // TODO Try to refactor and simplify this method
        int[] bool = Utils.getButtonState(buttons);
        String test = "X";
        while (test.matches("X")) {
            if (testLineX(bool, 0, 1, 2)) {
                buttons[2].setText(R.string.cross);
                buttons[2].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 0, 2, 1)) {
                buttons[1].setText(R.string.cross);
                buttons[1].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 0, 3, 6)) {
                buttons[6].setText(R.string.cross);
                buttons[6].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 0, 6, 3)) {
                buttons[3].setText(R.string.cross);
                buttons[3].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 0, 4, 8)) {
                buttons[8].setText(R.string.cross);
                buttons[8].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 0, 8, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 1, 4, 7)) {
                buttons[7].setText(R.string.cross);
                buttons[7].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 1, 7, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 1, 3, 0)) {
                buttons[0].setText(R.string.cross);
                buttons[0].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 2, 5, 8)) {
                buttons[8].setText(R.string.cross);
                buttons[8].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 2, 8, 5)) {
                buttons[5].setText(R.string.cross);
                buttons[5].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 2, 4, 6)) {
                buttons[6].setText(R.string.cross);
                buttons[6].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 3, 4, 5)) {
                buttons[5].setText(R.string.cross);
                buttons[5].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 3, 5, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 3, 6, 0)) {
                buttons[0].setText(R.string.cross);
                buttons[0].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 4, 7, 1)) {
                buttons[1].setText(R.string.cross);
                buttons[1].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 4, 5, 3)) {
                buttons[3].setText(R.string.cross);
                buttons[3].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 5, 8, 2)) {
                buttons[2].setText(R.string.cross);
                buttons[2].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 6, 4, 2)) {
                buttons[2].setText(R.string.cross);
                buttons[2].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 6, 2, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 6, 7, 8)) {
                buttons[8].setText(R.string.cross);
                buttons[8].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 6, 8, 7)) {
                buttons[7].setText(R.string.cross);
                buttons[7].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 7, 8, 6)) {
                buttons[6].setText(R.string.cross);
                buttons[6].setEnabled(false);
                test = "End";
            } else if (testLineX(bool, 8, 4, 0)) {
                buttons[0].setText(R.string.cross);
                buttons[0].setEnabled(false);
                test = "End";
            }else {
                test = "O";
            }
        }
        while (test.matches("O")) {
            if (testLineO(bool, 0, 1, 2)) {
                buttons[2].setText(R.string.cross);
                buttons[2].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 0, 2, 1)) {
                buttons[1].setText(R.string.cross);
                buttons[1].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 0, 3, 6)) {
                buttons[6].setText(R.string.cross);
                buttons[6].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 0, 6, 3)) {
                buttons[3].setText(R.string.cross);
                buttons[3].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 0, 4, 8)) {
                buttons[8].setText(R.string.cross);
                buttons[8].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 0, 8, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 1, 4, 7)) {
                buttons[7].setText(R.string.cross);
                buttons[7].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 1, 7, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 1, 3, 0)) {
                buttons[0].setText(R.string.cross);
                buttons[0].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 2, 5, 8)) {
                buttons[8].setText(R.string.cross);
                buttons[8].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 2, 8, 5)) {
                buttons[5].setText(R.string.cross);
                buttons[5].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 2, 4, 6)) {
                buttons[6].setText(R.string.cross);
                buttons[6].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 3, 4, 5)) {
                buttons[5].setText(R.string.cross);
                buttons[5].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 3, 5, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 3, 6, 0)) {
                buttons[0].setText(R.string.cross);
                buttons[0].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 4, 7, 1)) {
                buttons[1].setText(R.string.cross);
                buttons[1].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 4, 5, 3)) {
                buttons[3].setText(R.string.cross);
                buttons[3].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 5, 8, 2)) {
                buttons[2].setText(R.string.cross);
                buttons[2].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 6, 4, 2)) {
                buttons[2].setText(R.string.cross);
                buttons[2].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 6, 2, 4)) {
                buttons[4].setText(R.string.cross);
                buttons[4].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 6, 7, 8)) {
                buttons[8].setText(R.string.cross);
                buttons[8].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 6, 8, 7)) {
                buttons[7].setText(R.string.cross);
                buttons[7].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 7, 8, 6)) {
                buttons[6].setText(R.string.cross);
                buttons[6].setEnabled(false);
                test = "End";
            } else if (testLineO(bool, 8, 4, 0)) {
                buttons[0].setText(R.string.cross);
                buttons[0].setEnabled(false);
                test = "End";
            }else {
                test = "R";
            }
        }

        while (test.matches("R")) {
            int random = randInt(0, 8);
            while (bool[random] != 0) {
                random = randInt(0, 8);
            }
            buttons[random].setText(R.string.cross);
            buttons[random].setEnabled(false);
            test = "End";
        }
    }


    public static void endGame( Button[] buttons, int player, TextView tv, Button button, boolean computer){
        Utils.disable(buttons);
        if(player == 1){
            if(computer == true){
                tv.setText("Vous avez gagné");
            }else{
                tv.setText("Le joueur 1 gagne");
            }

        }else{
            if(computer){
                tv.setText("L'ordinateur gagne");
            }else{
                tv.setText("Le joueur 2 gagne");
            }
        }
        button.setEnabled(true);
    }

    public static void tieGame(TextView tv, Button button) {
        tv.setText("Egalité");
        button.setEnabled(true);
    }

    /**
     *
     * @param min
     * @param max
     * @return int aléatoire compris entre min et max inclus
     */
    public static int randInt(int min, int max) {

        // NOTE: Usually this should be a field rather than a method
        // variable so that it is not re-seeded every call.
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    /**
     *
     * @param bool state of the board
     * @param case1 first button state
     * @param case2 second button state
     * @param case3 third button state
     * @return true if two buttons of the same line is checked
     */
    private static boolean testLineX(int[] bool, int case1, int case2, int case3){

        if((bool[case1]==2)&&((bool[case2] == bool[case1])&&(bool[case3] == 0))) {
            return true;
        }
        return false;
    }
    private static boolean testLineO(int[] bool, int case1, int case2, int case3){

        if((bool[case1]==1)&&((bool[case2] == bool[case1])&&(bool[case3] == 0))) {
            return true;
        }
        return false;
    }
}
