package ind.milo.demo.basic;

public enum Season {
    SPRING, SUMMER, AUTOMN, WINTER;

    private Season(){
        System.out.println("Constructor called for : " + this.toString());
    }

    public static void main(String[] args) {
        //        System.out.println("spring name:"+Season.SPRING);
        System.out.println("spring name:" + Season.SPRING.name());
        System.out.println("spring ordinal:" + Season.SPRING.ordinal());
//        Season[] values = Season.values();
        System.out.println();
        for (Season season : Season.values()) {
            System.out.println(season + " at index " + season.ordinal());
        }
        Season season = Season.valueOf("SPRING");
        System.out.println(season);

        System.out.println(season == Season.SPRING);
    }
}

