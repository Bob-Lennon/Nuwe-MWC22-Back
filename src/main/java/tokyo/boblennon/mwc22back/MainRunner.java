package tokyo.boblennon.mwc22back;

import java.util.Scanner;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import picocli.CommandLine;
import tokyo.boblennon.mwc22back.domain.developer.DevCategoryEnum;
import tokyo.boblennon.mwc22back.domain.developer.Developer;
import tokyo.boblennon.mwc22back.infrastructure.developer.DevRepositoryImp;

@Component
public class MainRunner {

    Scanner sc = new Scanner(System.in);
    @CommandLine.Option(names = { "-n", "name" })
    private String name;
    @Autowired
    DevRepositoryImp devRepositoryImp;

    public void menu() {

        int opt;

        System.out.println(
                """

                        MMMMMMMM               MMMMMMMMWWWWWWWW                           WWWWWWWW      CCCCCCCCCCCCC      222222222222222     222222222222222
                        M:::::::M             M:::::::MW::::::W                           W::::::W   CCC::::::::::::C     2:::::::::::::::22  2:::::::::::::::22
                        M::::::::M           M::::::::MW::::::W                           W::::::W CC:::::::::::::::C     2::::::222222:::::2 2::::::222222:::::2
                        M:::::::::M         M:::::::::MW::::::W                           W::::::WC:::::CCCCCCCC::::C     2222222     2:::::2 2222222     2:::::2
                        M::::::::::M       M::::::::::M W:::::W           WWWWW           W:::::WC:::::C       CCCCCC                 2:::::2             2:::::2
                        M:::::::::::M     M:::::::::::M  W:::::W         W:::::W         W:::::WC:::::C                               2:::::2             2:::::2
                        M:::::::M::::M   M::::M:::::::M   W:::::W       W:::::::W       W:::::W C:::::C                            2222::::2           2222::::2
                        M::::::M M::::M M::::M M::::::M    W:::::W     W:::::::::W     W:::::W  C:::::C                       22222::::::22       22222::::::22
                        M::::::M  M::::M::::M  M::::::M     W:::::W   W:::::W:::::W   W:::::W   C:::::C                     22::::::::222       22::::::::222
                        M::::::M   M:::::::M   M::::::M      W:::::W W:::::W W:::::W W:::::W    C:::::C                    2:::::22222         2:::::22222
                        M::::::M    M:::::M    M::::::M       W:::::W:::::W   W:::::W:::::W     C:::::C                   2:::::2             2:::::2
                        M::::::M     MMMMM     M::::::M        W:::::::::W     W:::::::::W       C:::::C       CCCCCC     2:::::2             2:::::2
                        M::::::M               M::::::M         W:::::::W       W:::::::W         C:::::CCCCCCCC::::C     2:::::2       2222222:::::2       222222
                        M::::::M               M::::::M          W:::::W         W:::::W           CC:::::::::::::::C     2::::::2222222:::::22::::::2222222:::::2
                        M::::::M               M::::::M           W:::W           W:::W              CCC::::::::::::C     2::::::::::::::::::22::::::::::::::::::2
                        MMMMMMMM               MMMMMMMM            WWW             WWW                  CCCCCCCCCCCCC     2222222222222222222222222222222222222222
                        """);
        while (true) {
            System.out.println(
                    """
                            ..........................................................................................................................................
                            .                                      CLI Application for the Hackathon contest at MWC 22 | 4FYN |                                      .
                            .                                                                                                                                        .
                            .        Select an option                                                                                                                .
                            .                                                                                                                                        .
                            .        1.- Which days will MWC 2022 be held                                                                                            .
                            .        2.- Display list of programmers                                                                                                 .
                            .        3.- Add a new programmer                                                                                                        .
                            .        4.- Exit                                                                                                                        .
                            .                                                                                                                                        .
                            ..........................................................................................................................................
                                """);

            opt = sc.nextInt();

            switch (opt) {
                case 1:
                    this.mwcDays();
                    break;
                case 2:
                    this.displayDevs();
                    break;
                case 3:
                    this.addDev();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select an option from 1 to 5 !!!");
                    break;
            }
        }
    }

    private void mwcDays() {
        System.out.println("The MWC 2022 will be held the days: 28 Feb and 1-3 March");
    }

    private void displayDevs() {
        for (Developer d : this.devRepositoryImp.getAll()) {
            System.out.println(d.toString());
        }
    }

    private void addDev() {
        try {
            // Auto-generated UUID
            String id = UUID.randomUUID().toString();
            sc.nextLine();
            System.out.println("What is the name of the Developer?");
            String name = sc.nextLine();

            System.out.println("In which category is he participating?    ( Front, Back, Mobile, Data )");
            DevCategoryEnum category = DevCategoryEnum.valueOf(sc.next());

            System.out.println("What day will he be attending the congress?    ( 28th, 1, 2, 3 )");
            String date = "";
            switch (sc.nextInt()) {
                case 1:
                date = "Mar 1, 2022";
                break;
                case 2:
                date = "Mar 2, 2022";
                break;
                case 3:
                date = "Mar 3, 2022";
                break;
                case 28:
                date = "Feb 28, 2022";
                break;
                default:
                    System.out.println("ERROR !!!    Try again selecting one of the days listed.");
                    return;
            }

            
            System.out.println("What is his contact email?  Please, use email format !!");
            String email = sc.next();

            System.out.println("What is his contact phone?");
            String phone = sc.next();

            this.devRepositoryImp.add(new Developer(id, name, email, category, phone, date));

            System.out.println("The developer " + name + "  has been added to the list of participants");
        } catch (java.lang.IllegalArgumentException e) {
            System.out.println("ERROR !!!    You must write the category name correctly.");
        }
    }

}
