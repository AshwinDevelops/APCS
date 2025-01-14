import java.util.Scanner;

public class Runner
{

    //profiles -- instantiated profiles of career class declared as global variables(so I can access them from any function)
    private static Career p1 = new Career("john smith", 28, "science", "music", "cookies");
    private static Career p2 = new Career("adam levington", 34, "math", "sports", "pizza");
    private static Career p3 = new Career("lucy lemon", 26, "english", "music", "pizza");

    //generic instance variables
    private static boolean running=true;
    private static Scanner input = new Scanner(System.in);

    //overwrite input profile variables
    private static String owName;
    private static int owAge;
    private static String owSubject;
    private static String owHobby;
    private static String owFood;
    //private static String owResponse;


    public static void main(String[] args)
    {
        while(true)//continously loop
        {
            if(running)
                startUserProgram();
            if(!running)
                return;
        }
        
    }

    public static void startUserProgram()
    {
        //print info
        p1.printInfo();
        p2.printInfo();
        p3.printInfo();
        System.out.println("What profile would you like to edit? ['p1', 'p2', 'p3']. Enter 'exit' to exit the program.");
        String uProfile = input.next();
        input.nextLine();//clear dumb java bug
        if(uProfile.toLowerCase().equals("p1"))
        {
            setOWInfo();
            p1.updateProfile(owName, owAge, owSubject, owHobby, owFood);
        }
        else if(uProfile.toLowerCase().equals("p2"))
        {
            setOWInfo();
            p2.updateProfile(owName, owAge, owSubject, owHobby, owFood);
        }
        else if(uProfile.toLowerCase().equals("p3"))
        {
            setOWInfo();
            p3.updateProfile(owName, owAge, owSubject, owHobby, owFood);
        }
        else if(uProfile.toLowerCase().equals("exit")) { running = false; }
        else//(!(uProfile.toLowerCase().equals("p2")||uProfile.toLowerCase().equals("p2")||uProfile.toLowerCase().equals("p3")))
        {
            System.out.println("Invalid Profile Selected...");
        }
    }

    private static void setOWInfo()//get input for all subjects -- setOverWriteInfo 
    {
        System.out.println("Enter in new name: ");
        owName = input.nextLine().toLowerCase();
        System.out.println("Enter in new age: ");
        owAge = input.nextInt();
        input.nextLine();//fix line bug

        //subject
        System.out.println("Enter in new subject. Choices: [Math, Science, English]");
        owSubject = input.nextLine().toLowerCase();
        if(!(owSubject.toLowerCase().equals("math")||owSubject.toLowerCase().equals("science")||owSubject.toLowerCase().equals("english")))
        {
            System.out.println("Invalid subject entered. Subject defaulted to 'Math'");
            owSubject = "math";
        }
        //hobby
        System.out.println("Enter in new hobby. Choices: [Sports, Music]");
        owHobby = input.nextLine().toLowerCase();
        if(!(owHobby.toLowerCase().equals("sports")||owHobby.toLowerCase().equals("music")))
        {
            System.out.println("Invalid subject entered. Hobby defaulted to 'Sports'");
            owHobby = "sports";
        }

        //food
        System.out.println("Enter in new food. Choices: [Pizza, Cookies]");
        owFood = input.nextLine().toLowerCase();
        if(!(owFood.toLowerCase().equals("pizza")|| owFood.toLowerCase().equals("cookies")))
        {
            System.out.println("Invalid subject entered. Hobby defaulted to 'Pizza'");
            owFood = "pizza";
        }
    }
}