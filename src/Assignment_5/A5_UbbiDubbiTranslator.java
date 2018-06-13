/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment_5;

import java.util.Scanner;

/**
 *
 * @author Omar
 */
public class A5_UbbiDubbiTranslator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Continually repeat the translation process
        while (true) {

            Scanner input = new Scanner(System.in);
            System.out.println("Enter 'English' to translate from English to Ubbi Dubbi and 'Ubbi Dubbi' to translate from Ubbi Dubbi to English.");
            String translator = input.nextLine();
            if (translator.contains("English")) {
                //Prompt the user to enter in a sentence or word 
                System.out.println("Enter in a sentence or word in regular English:");
                String wordOrSentence = input.nextLine();

                //Change the case of all letters in the word for ease of translation
                wordOrSentence = wordOrSentence.toLowerCase();

                //Change the original word/sentence to a new variable in order for every version of the translation to be combined into one translation.
                String translatedWord = " " + wordOrSentence;

                //Check every single letter position of the word or sentence to search for vowels.
                for (int letterPosition = 0; letterPosition < translatedWord.length(); letterPosition++) {

                    if (translatedWord.charAt(letterPosition) == 'a'
                            || translatedWord.charAt(letterPosition) == 'e'
                            || translatedWord.charAt(letterPosition) == 'i'
                            || translatedWord.charAt(letterPosition) == 'o'
                            || translatedWord.charAt(letterPosition) == 'u') {

                        //If for any reason there is a vowel before another vowel, do not at ub in front of the vowel. This allows only one ub to be placed in front a of string of multiple vowels.
                        if (!(translatedWord.charAt(letterPosition - 1) == 'a'
                                || translatedWord.charAt(letterPosition - 1) == 'e'
                                || translatedWord.charAt(letterPosition - 1) == 'i'
                                || translatedWord.charAt(letterPosition - 1) == 'o'
                                || translatedWord.charAt(letterPosition - 1) == 'u')) {
                            //Break up the word into two parts, one before the vowel and one including the vowel and continuing to the end of the sentence/word.
                            String startOfWordOrSentence = translatedWord.substring(0, letterPosition);
                            String endOfWordOrSentence = translatedWord.substring(letterPosition);

                            //Create the translated word by adding ub between the segments (this adds ub in front of the vowel).
                            translatedWord = startOfWordOrSentence + "ub" + endOfWordOrSentence;

                            //After adding ub before the vowel, move three characters forward to continue checking the next letter in the word/sentence.
                            letterPosition = letterPosition + 2;

                        }
                    }
                }
                //Display the translated version of the English word/sentence to the user.
                System.out.println(wordOrSentence + " is" + translatedWord + " in Ubbi Dubbi!");
            }
            if (translator.contains("Ubbi Dubbi")) {

                //Prompt the user to enter in a sentence or word in Ubbi Dubbi
                System.out.println("Enter in a sentence or word in Ubbi Dubbi:");
                String wordOrSentence = input.nextLine();

                //Change the case of all letters in the word for ease of translation
                wordOrSentence = wordOrSentence.toLowerCase();

                //Change the original word/sentence to a new variable in order for every version of the translation to be combined into one translation.
                String translatedWord = " " + wordOrSentence;

                //Check every single letter position of the word or sentence to search for vowels.
                for (int letterPosition = 0; letterPosition < translatedWord.length(); letterPosition++) {

                    if (translatedWord.charAt(letterPosition) == 'a'
                            || translatedWord.charAt(letterPosition) == 'e'
                            || translatedWord.charAt(letterPosition) == 'i'
                            || translatedWord.charAt(letterPosition) == 'o'
                            || translatedWord.charAt(letterPosition) == 'u') {

                        //Break up the word into three parts, one before the vowel, one that could potentially contain a "ub", and one including the vowel and continuing to the end of the sentence/word.
                        String startOfWordOrSentence = translatedWord.substring(0, letterPosition - 2);
                        String removeUB = translatedWord.substring(letterPosition - 2, letterPosition);
                        String endOfWordOrSentence = translatedWord.substring(letterPosition);

                        //Remove a "ub" from the word or sentence.
                        if (removeUB.endsWith("ub")) {
                            translatedWord = startOfWordOrSentence + endOfWordOrSentence;
                        }
                        //If there is no "ub" at a particular location, recombine the sentence/word and continue searching.
                        if (!removeUB.endsWith("ub")) {
                            translatedWord = startOfWordOrSentence + removeUB + endOfWordOrSentence;
                        }
                    }
                }
                //Display the translated version of the Ubbi Dubbi word/sentence to the user.
                System.out.println(wordOrSentence + " is" + translatedWord + " in English!");
            }
        }
    }
}
