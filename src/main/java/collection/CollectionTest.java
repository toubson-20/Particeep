package collection;

import java.util.ArrayList;
import java.util.List;

/**
 * You should complete the function in this class
 * <p>
 * Feel free to define any method and / or class you want
 */
class CollectionTest {


  /**
   * operation : x -> ((x * 2) + 3) ^ 5
   */

  public static List<Double> compute1(List<Integer> input) {
    List<Double> list = new ArrayList<>();
    for(int i=0; i<input.size(); i++){
      double calcul = ((input.get(i) * 2) +3);
      list.add(Math.pow(calcul,5));
    }
    return list;
  }

  /**
   * operation : abc -> AbcAbc
   */
  public static List<String> compute2(List<String> input) {
    for(int i=0; i<input.size(); i++) {
      String word = input.get(i);
      String[] tab = word.split(""); // je sépare le mot càd chaque caractère du mot est dans une case du tableau
      tab[0] = tab[0].toUpperCase(); //je mets la première lettre en majuscule
      String newWord="";
      for(int j=0; j<tab.length;j++) {
        newWord += tab[j]; // j'associe le mot
      }
      newWord += newWord; // je duplique le mot Abc devient AbcAbc
      input.set(i, newWord); // je remplace le mot dans la liste


      /*ou
       * String word = input.get(i);
       * String newWord = word.replaceFirst(".", (mot.charAt(0)+"").toUpperCase()); // je mets la première lettre en majuscule
       * newWord += newWord; // je duplique e.g: le mot Abc devient AbcAbc
       * input.set(i, newWord); // je remplace le mot dans la liste
       */
    }
    return input;
  }

}