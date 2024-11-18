/*
import java.util.*;
 class Filer
{
    String Financial[] = {"cash back","bonus","fast cash","money back","one hundred percent","credit card","debit card","income"};
    String Marketting[] = {"click","click to","month trial offer","subscribe","visit our website"};
    String Medical[] = {"cure baldness","weight loss","viagra","life insurance"};
    String Numbers[] = {"100%","billion","million","dollars","satisfied","one"};
    String Social[] = {"facebook,twitter","instagram","new","notifcation","request","from"};
    String subject="";



    String  Spamsub[] = new String[100];
    String  Spam[] = new String[100];
    String  nonSpamsub[] = new String[100];
    String  nonSpam[] = new String[100];

    int scounter =1,ncounter=1;


    boolean condition = false;



    String msg="";



    public void menu(int a)
    {
        if(a==0)
        {
            System.out.println("Spam Filer \n\n");
            System.out.println("1.Compose Email");
            System.out.println("2.Inbox");
            System.out.println("3.Exit");
            System.out.println("Enter Your Option");

            Scanner sc = new Scanner(System.in);
            int option = sc.nextInt();

            switch (option)
            {
                case 1:
                    composeEmail();
                    break;
                case 2:
                    inbox();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default :
                    System.out.println("Try Aagain");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clear();
                    menu(0);
            }
        }
        else if(a==1)
        {
            System.out.println("Do want to Send Email?");
            System.out.println("1.Yes");
            System.out.println("2.No(Take me back to the Starting Screen)");
            System.out.println("Enter your Option");
            Scanner fcc = new Scanner(System.in);
            int option = fcc.nextInt();
            //String ff =sc.next();

            switch (option)
            {
                case 1:
                    analyse();
                    break;
                case 2:
                    clear();
                    menu(0);
                default:
                    System.out.println("Try Aagain");
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    clear();
                    menu(0);
            }
        }
    }

    public void composeEmail()
    {
        clear();
        System.out.println("FROM: userDsce@gmail.com");
        System.out.println("To:   garfield007@gmail.com\n\n");
        System.out.println("Enter the Subject (Type Skip to Move on)\n");
        System.out.print("Subject:  ");
        Scanner sc00 = new Scanner(System.in);
         subject = sc00.next();
         if(subject.toLowerCase().equals("skip"))
             subject ="No subject";

        clear();

        System.out.println("FROM: userDsce@gmail.com");
        System.out.println("To:   garfield007@gmail.com");
        System.out.println("Subject: "+subject+"\n\n");

        System.out.println("(Compose the Email)\n\n");
        Scanner sc2 = new Scanner(System.in);
        msg = sc2.nextLine();

        clear();
        System.out.println("FROM: userDsce@gmail.com");
        System.out.println("To:   garfield007@gmail.com");
        System.out.println("Subject: "+subject+"\n\n");
        System.out.println("Email:");
        System.out.println(msg);
        System.out.println("\n\n----------------------x------------------");

        System.out.println("\n\n");
        menu(1);
    }

    public void inbox()
    {
        clear();
        System.out.println("1.Spam Mail");
        System.out.println("2.Non Spam mail");
        System.out.println("Select ur option");
        Scanner dd = new Scanner(System.in);
        int option = dd.nextInt();

        switch (option)
        {
            case 1:
                print(Spamsub);
                System.out.println("Select ur option");
                Scanner dd2 = new Scanner(System.in);
                int option2 = dd.nextInt();
                clear();
                System.out.println("Message is");
                System.out.println(Spam[option2]+"\n\n");
                System.out.println("Return to Main menu?");
                System.out.println("1.YES");
                System.out.println("2.No");
                System.out.println("Enter your choice");
                int option3 = dd2.nextInt();
                clear();
                if(option3==1)
                    menu(0);
                else
                    System.exit(0);
                break;
            case 2:
                print(nonSpamsub);
                System.out.println("Select ur option");
                Scanner dd22 = new Scanner(System.in);
                int option22 = dd.nextInt();
                clear();
                System.out.println("Message is");
                System.out.println(nonSpam[option22]+"\n\n");
                System.out.println("Return to Main menu?");
                System.out.println("1.YES");
                System.out.println("2.No");
                System.out.println("Enter your choice");
                int option33 = dd22.nextInt();
                clear();
                if(option33==1)
                    menu(0);
                else
                    System.exit(0);
                break;
            default:
                System.out.println("Try Aagain");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clear();
                menu(0);

        }


    }

    private void clear()
    {
        for (int i=1;i<=25;i++)
        {
            System.out.println("\n");
        }
    }

    void analyse()
    {

     analyse2(Financial,msg);
     analyse2(Social,msg);
     analyse2(Marketting,msg);
     analyse2(Numbers,msg);
     analyse2(Medical,msg);

        clear();
        System.out.println("Message Sent");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clear();
        if(condition)
        {
            Spamsub[scounter] = subject;
            Spam[scounter] = msg;
            scounter = scounter+1;
        }
        else
        {
            nonSpamsub[ncounter] = subject;
            nonSpam[ncounter] = msg;
            ncounter = ncounter+1;
        }

        condition = false;
        menu(0);
    }

    void  analyse2(String arr[],String msg)
    {
        String message = msg.toLowerCase();
        int score =0;

        //System.out.println("Apple");

        for(int j=0;j<arr.length;j++)
        {
            String pattern = arr[j];
            int pos;

            if(pattern.length()<=msg.length())
            {
                Horspool h = new Horspool();
                pos = h.execute(msg,pattern);
                if(pos>0)
                    score++;
            }

        }
        if(score>=(arr.length/3.5))
            condition = true;
    }


    void print(String arr[])
    {
        for(int i=1;i<arr.length;i++)
            if(arr[i]!=null)
            System.out.println(i+"."+arr[i]);
    }

}

*/
import java.util.*;

class Filer {
    String Financial[] = {"cash back","bonus","fast cash","money back","one hundred percent","credit card","debit card","income"};
    String Marketting[] = {"click","click to","month trial offer","subscribe","visit our website"};
    String Medical[] = {"cure baldness","weight loss","viagra","life insurance"};
    String Numbers[] = {"100%","billion","million","dollars","satisfied","one"};
    String Social[] = {"facebook,twitter","instagram","new","notifcation","request","from"};
    String subject = "";

    String Spamsub[] = new String[100];
    String Spam[] = new String[100];
    String nonSpamsub[] = new String[100];
    String nonSpam[] = new String[100];

    int scounter = 0, ncounter = 0;

    boolean condition = false;

    String msg = "";

    public void menu(int a) {
        while (true) {
            if (a == 0) {
                System.out.println("Spam Filer \n\n");
                System.out.println("1.Compose Email");
                System.out.println("2.Inbox");
                System.out.println("3.Exit");
                System.out.println("Enter Your Option");

                Scanner sc = new Scanner(System.in);
                int option = sc.nextInt();

                switch (option) {
                    case 1:
                        composeEmail();
                        break;
                    case 2:
                        inbox();
                        break;
                    case 3:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Try Again");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clear();
                        // Instead of recursion, loop will continue
                }
            } else if (a == 1) {
                System.out.println("Do you want to send the Email?");
                System.out.println("1.Yes");
                System.out.println("2.No(Take me back to the Starting Screen)");
                System.out.println("Enter your Option");
                Scanner fcc = new Scanner(System.in);
                int option = fcc.nextInt();

                switch (option) {
                    case 1:
                        analyse();
                        break;
                    case 2:
                        clear();
                        a = 0; // Return to main menu
                        break;
                    default:
                        System.out.println("Try Again");
                        try {
                            Thread.sleep(300);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        clear();
                        a = 0; // Return to main menu
                }
            }
        }
    }

    public void composeEmail() {
        clear();
        System.out.println("FROM: userDsce@gmail.com");
        System.out.println("To:   garfield007@gmail.com\n\n");
        System.out.println("Enter the Subject (Type Skip to Move on)\n");
        System.out.print("Subject:  ");
        Scanner sc00 = new Scanner(System.in);
        subject = sc00.nextLine(); // To read multi-word subject
        if (subject.toLowerCase().equals("skip")) {
            subject = "No subject";
        }

        clear();

        System.out.println("FROM: userDsce@gmail.com");
        System.out.println("To:   garfield007@gmail.com");
        System.out.println("Subject: " + subject + "\n\n");

        System.out.println("(Compose the Email)\n\n");
        Scanner sc2 = new Scanner(System.in);
        msg = sc2.nextLine();

        clear();
        System.out.println("FROM: userDsce@gmail.com");
        System.out.println("To:   garfield007@gmail.com");
        System.out.println("Subject: " + subject + "\n\n");
        System.out.println("Email:");
        System.out.println(msg);
        System.out.println("\n\n----------------------x------------------");

        System.out.println("\n\n");
        menu(1);
    }

    public void inbox() {
        clear();
        System.out.println("1.Spam Mail");
        System.out.println("2.Non Spam mail");
        System.out.println("Select your option");
        Scanner dd = new Scanner(System.in);
        int option = dd.nextInt();

        switch (option) {
            case 1:
                print(Spamsub);
                System.out.println("Select your option");
                int option2 = dd.nextInt();
                clear();
                System.out.println("Message is");
                System.out.println(Spam[option2] + "\n\n");
                break;
            case 2:
                print(nonSpamsub);
                System.out.println("Select your option");
                int option22 = dd.nextInt();
                clear();
                System.out.println("Message is");
                System.out.println(nonSpam[option22] + "\n\n");
                break;
            default:
                System.out.println("Try Again");
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                clear();
        }

        System.out.println("Return to Main menu?");
        System.out.println("1.YES");
        System.out.println("2.No");
        System.out.println("Enter your choice");
        int option3 = dd.nextInt();
        if (option3 == 1) {
            clear();
            menu(0);
        } else {
            System.exit(0);
        }
    }

    private void clear() {
        for (int i = 1; i <= 25; i++) {
            System.out.println("\n");
        }
    }

    void analyse() {
        analyse2(Financial, msg);
        analyse2(Social, msg);
        analyse2(Marketting, msg);
        analyse2(Numbers, msg);
        analyse2(Medical, msg);

        clear();
        System.out.println("Message Sent");

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        clear();

        if (condition) {
            Spamsub[scounter] = subject;
            Spam[scounter] = msg;
            scounter++;
        } else {
            nonSpamsub[ncounter] = subject;
            nonSpam[ncounter] = msg;
            ncounter++;
        }

        condition = false;
        menu(0);
    }

    void analyse2(String arr[], String msg) {
        String message = msg.toLowerCase();
        int score = 0;

        for (String pattern : arr) {
            int pos;
            if (pattern.length() <= msg.length()) {
                pos = message.indexOf(pattern.toLowerCase());
                if (pos >= 0) {
                    score++;
                }
            }
        }

        if (score > 0) {
            condition = true;
        }
    }

    public void print(String arr[]) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                System.out.println((i + 1) + "." + arr[i]);
            }
        }
    }

    public static void main(String args[]) {
        Filer f = new Filer();
        f.menu(0);
    }
}
