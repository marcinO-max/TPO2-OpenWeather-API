/**
 *
 *  @author Ossowski Marcin S16425
 *
 */

package zad1;


public class Main {
  public static void main(String[] args) {
    Service s = new Service();
    String weatherJson = s.getWeather("Italy");
    Double rate1 = s.getRateFor("USD");
    Double rate2 = s.getNBPRate();
    // ...
    // część uruchamiająca GUI
    Gui gui = new Gui(weatherJson, 3.0, rate2);
    
 
 
  }
}
