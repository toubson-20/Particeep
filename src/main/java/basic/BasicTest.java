package basic;

import io.vavr.control.Option;

/**
 * For this basic test, you should not use any library. e.g. you should not use
 * Math.pow for power method
 */
public class BasicTest {

  /**
   * return i ^ n for positive Integer, None otherwise
   * alse return None in case of errors
   */
  public static Option<Integer> power(Integer i, Integer n) {
    if(i>=0){
      int result = 1;
        for(int j=1; j<=n; j++) {
          result *= n; 
        }
      return Option.of(result);
    }else{
      return Option.none();
    }
  }
}