package ind.milo.demo.algorithm;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ChangeMoney {
    private static Pattern pattern1 = Pattern.compile("[A-Z]");

    public static void main(String[] args) {
        char a = '0';
        System.out.println((byte)('0')); // 48
        System.out.println((byte)('9')); // 57

    }

    public static void decode(String password) {
        char[] passwordArr = password.toCharArray();

        for (int i = 0; i < passwordArr.length; i++) {
            Character chr = passwordArr[i];
            if (Character.isLetter(chr)) {
                if ('a' == chr) {
                    passwordArr[i] = 'Z';
                    continue;
                }

                if ('A' == chr) {
                    passwordArr[i] = 'z';
                    continue;
                }

                if (Character.isUpperCase(chr)) {
                    passwordArr[i] = Character.toLowerCase((char) (chr - 1));
                    continue;
                }


                if (Character.isLowerCase(chr)) {
                    passwordArr[i] = Character.toUpperCase((char) (chr - 1));
                    continue;
                }
            }

            if (Character.isDigit(chr)) {
                if (chr == '0') {
                    passwordArr[i] = '9';
                    continue;
                }

                passwordArr[i] = (char) (chr - 1);
            }

            System.out.println(passwordArr);
        }
    }

    public static boolean hasMoreThanTreeModel(String str) {
        int score = 0;
        if (str.matches("[A-Z]")) {
            score ++;
        }

        if (str.matches("[a-z]")) {
            score ++;
        }

        if (str.matches("[0-9]")) {
            score ++;
        }

        if (str.matches("^[A-Za-z0-9]")) {
            score ++;
        }
        System.out.println(score);
        return score >= 3;
    }
}
