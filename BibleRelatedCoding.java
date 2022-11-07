import java.util.Random;

public class BibleRelatedCoding {
    static void timeToMakeDisciiples(){
        Long population = 7700000000L;
        Long numberOfDisciples = 13L;
        int i = 0;
        while(numberOfDisciples <= population){
            numberOfDisciples += numberOfDisciples * 2;
            i += 3;
        }
        System.out.println("It will take "+i+" years to make every human a disciple of Jesus");
    }

    static void timeToMakeDisciiplesWithCondition(){
        Long population = 7700000000L;
        Long numberOfDisciples = 13L;
        Random rand = new Random();
        int i = 0;
        while(numberOfDisciples <= population){
            int numberOfSlots = rand.nextInt(2);
            numberOfDisciples += numberOfDisciples * numberOfSlots;
            i += 30;
        }
        System.out.println("It will take "+i+" years to make every human a disciple of Jesus with new condition");
    }

    public static void main(String[] args){
        timeToMakeDisciiples();
        timeToMakeDisciiplesWithCondition();
    }
}
