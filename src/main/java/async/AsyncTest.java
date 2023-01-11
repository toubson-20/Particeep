package async;

import io.vavr.collection.List;
import io.vavr.*;
import io.vavr.control.Option;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import javax.lang.model.element.Element;
import javax.naming.spi.DirStateFactory.Result;

/**
 * You should complete the function in this class
 */
class AsyncTest {

  private static List<Enterprise> enterprises = List.of(
      new Enterprise("ent_1", "Google", "ceo_2"),
      new Enterprise("ent_2", "Facebook", "ceo_1")
  );

  private static List<Ceo> ceos = List.of(
      new Ceo("ceo_1", "Mark"),
      new Ceo("ceo_2", "Sundar"),
      new Ceo("ceo_3", "Bill")
  );

  public static CompletableFuture<List<Ceo>> getCeoById(String ceo_id, List<Ceo> cList) {
    return CompletableFuture.supplyAsync(() -> {
      return cList.filter(element -> (element.id.compareTo(ceo_id) == 0));
    }).thenApply(list -> {
      return list;
    });
  }


  public static CompletableFuture<List<Enterprise>> getEnterpriseByCeoId(String ceo_id, List<Enterprise> eList ) {
    return CompletableFuture.supplyAsync(() -> {
      return eList.filter(element -> (element.ceo_id.compareTo(ceo_id) == 0));
    }).thenApply(list -> {
      return list;
    });
  }


  public static CompletableFuture<Tuple2<Option<Ceo>, Option<Enterprise>>> getCEOAndEnterprise(String ceo_id, List<Enterprise> eList, List<Ceo> cList) {
    Option oCeo = cList.isEmpty() ? Option.none() : Option.of(cList.get());
    Option oEnterprise = eList.isEmpty() ? Option.none() : Option.of(eList.get());
    Tuple2<Option<Ceo>, Option<Enterprise>> tuple;
    return CompletableFuture.supplyAsync(() -> {
      return tuple.of(oCeo, oEnterprise);
    })
  }

  public static List<Ceo> get(List<Ceo> list, String id ) {
    for(Ceo ceo : list){
      if(ceo.id.compareTo(id) != 0){
        list = list.remove(ceo);
      }
    }
    return list;
  }


  public static void main(String[] args) throws InterruptedException, ExecutionException{
    List<String> l = List.of("oui");
    Option oCeo = l.isEmpty() ? Option.none() : Option.of(l.get());

    System.out.println(oCeo);
  }
}
