package code;

import java.util.Scanner;

import static java.lang.System.exit;

public class Menu {
    Services services;
    Menu() {
        services = new Services();
        Welcome();
        MainMenuOptions();
    }
    public void Welcome() {
        System.out.println("Welcome to Univercity");
    }
    public void MainMenuOptions() {
        System.out.println("1 : Initialize Univercity");
        System.out.println("2 : Show Univercity structure");
        System.out.println("3 : Select TeamLeader");
        System.out.println("4 : Show program reference");
        System.out.println("5 : RollCallGroup");
        System.out.println("6 : Exit program");
        ChooseOption(0, 6);
    }
    public void RollCallOpt() {
        System.out.println("Chose a group to make a RollCall : ");
        System.out.println(" 1 for MATH");
        System.out.println(" 2 for HISTORY");
        System.out.println(" 3 for BIOLOGY");
        System.out.println(" 4 for SPORT");
        System.out.println(" 5 for All Groups");
        System.out.println(" 6 for EXIT to Main Menu");
        ChooseOption(1, 6);
    }
    public void ChooseOption(int menu, int optRange) {
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        if (scanner.hasNextInt())
            option = scanner.nextInt();
        if ((option > 0) && (option < optRange + 1))
            SelectService(option, menu);
        else WrongOption(option, menu, optRange);
    }
    public void WrongOption(int option, int menu, int optRange) {
        if (option == 0)
            System.out.println("you have pressed a wrong key");
        else
            System.out.println("you have chosen a wrong option " + option + " out of range 0 to " + optRange);
        switch (menu) {
            case 0:
                MainMenuOptions();
                break;
            case 1:
                RollCallOpt();
                break;
        }
    }
    public void SelectService(int option, int menu) {
        int i;
        switch (menu) {
            case 0:
                switch (option) {
                    case 1:
                        System.out.println("option " + option);
                        services.SetUniver();
                        services.SetScore();
                        services.SetGroups();
                        services.SetStudents();
                        services.SetProfs();
                        MainMenuOptions();
                        break;
                    case 2:
                        System.out.println("option " + option);
                        i = services.ChechUnivFound();
                        if (i == 1) {
                            services.UnivStructure();
                            MainMenuOptions();
                            break;
                        } else {
                            System.out.println("Univer is not found yet. Please establish it first");
                            System.out.println("");
                            MainMenuOptions();
                            break;
                        }
                    case 3:
                        System.out.println("option " + option);
                        i = services.ChechUnivFound();
                        if (i == 1) {
                            services.Election();
                            MainMenuOptions();
                            break;
                        } else {
                            System.out.println("Univer is not found yet. Please establish it first");
                            System.out.println("");
                            MainMenuOptions();
                            break;
                        }
                    case 4:
                        System.out.println("option " + option);
                        System.out.println("");
                        System.out.println("HELLO! This is a simple UNIVERSITY simulator. Enjoy it");
                        System.out.println("");
                        System.out.println("First you shoud establish a University if you did not");
                        System.out.println("");
                        MainMenuOptions();
                        break;
                    case 5:
                        System.out.println("option " + option);
                        i = services.ChechUnivFound();
                        if (i == 1){
                            RollCallOpt();
                            MainMenuOptions();
                            break;}
                        else {
                            System.out.println("Univer is not found yet. Please establish it first");
                            System.out.println("");
                            MainMenuOptions();
                            break;
                        }
                    case 6:
                        System.out.println("option " + option);
                        System.out.println("Good bye");
                        exit(0);
                }
            case 1:
                switch (option) {
                    case 2:
                    case 3:
                    case 4:
                        System.out.println("option " + option);
                        services.StudRollCall(option);
                        break;
                    case 5:
                        System.out.println("option " + option);
                        services.StudRollCall(1);
                        services.StudRollCall(2);
                        services.StudRollCall(3);
                        services.StudRollCall(4);
                        break;
                    case 6:
                        System.out.println("option " + option);
                        MainMenuOptions();
                        break;
                }
        }
    }
}