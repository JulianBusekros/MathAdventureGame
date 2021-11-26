import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;

public class AdventureGameEngine {

    private static final Player player = new Player("Julian");
    private static final AdventureMap adventureMap = new AdventureMap();
    private static final Map<Integer, Location> locations = new HashMap<>(adventureMap.getLocations());
    private final EventsByResult eventsByResult = new EventsByResult();
    private final Scanner scanner = new Scanner(System.in);
    private final Map<String, String> vocabularyForNavigation = new HashMap<>();
    private final Calculation calculation = new Calculation();
    private final MathTaskGenerator mathTaskGenerator = new MathTaskGenerator();
    private final CreateRandomEvent createRandomEvent = new CreateRandomEvent();
    Map<String, Integer> exits;
    private String directions;
    private String result;
    private String equation;
    private String event;
    private int loc = 1;

    public void startGame(){

        createVocabularyForNavigation();

        while(true){

            if(loc == 0){
                System.out.println("Quiting the game...");
                break;
            }

            setAndPrintVariables();

            compareUserInputToResult();

            if(player.getHealth() <= 0){
                break;
            }
            setAndPrintExits();

            inputDirections();

            directionValidation();
        }
    }

    private void createVocabularyForNavigation(){
        vocabularyForNavigation.put("QUIT", "Q");
        vocabularyForNavigation.put("NORTH", "N");
        vocabularyForNavigation.put("SOUTH", "S");
        vocabularyForNavigation.put("EAST", "E");
        vocabularyForNavigation.put("WEST", "W");
    }

    private void setResult(){
        result = calculation.doCalculation(equation);
        result = result.substring(0, result.indexOf("."));
        System.out.println(result);
    }

    private void setEquation(){
        equation = mathTaskGenerator.getRandomEquation();
    }

    private void setEvent(){
        event = createRandomEvent.getRandomEvent();
    }

    private void setAndPrintVariables(){
        System.out.println(locations.get(loc).getDescription());
        setEvent();
        System.out.println(event);
        System.out.println("-------------");
        setEquation();
        System.out.println(equation);
        setResult();
        System.out.println("-------------");
    }

    private void compareUserInputToResult(){
        String input = scanner.nextLine();

        if(!input.equals(result)){
            eventsByResult.eventIfResultIsFalse(event);
        }else{
            eventsByResult.eventsIfResultIsTrue(event);
        }
    }

    private void setAndPrintExits(){
        exits = locations.get(loc).getLocationExits();
        System.out.println("Your options are:  ");
        for(String exit: exits.keySet()){
            System.out.print(exit + "   ");
        }
        System.out.println();
    }

    private void inputDirections(){
        directions = scanner.nextLine().toUpperCase(Locale.ROOT);

        if(directions.length() > 1){
            String[] words = directions.split(" ");
            for(String word : words){
                if(vocabularyForNavigation.containsKey(word)){
                    directions = vocabularyForNavigation.get(word);
                    break;
                }
            }
        }
    }

    private void directionValidation(){
        if(exits.containsKey(directions)){
            loc = exits.get(directions);
        } else{
            System.out.println("You can't go in that direction");
        }
    }
}
