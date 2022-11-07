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

    public static void main(String[] args){
        timeToMakeDisciiples();
    }
}
