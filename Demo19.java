import java.util.Scanner;

void main () {

    int studentIdCounter = 1;
    final Scanner SCANNER = new Scanner(System.in);
    String allNames = "";
    String allIds = "";
    String pFMarks = "";
    String oSMarks = "";
    int numberOfStudents = 0;
    int studentNumber = 0;
    final String CLEAR = "\033[H\033[2J";

    main:
    while (true) {
        System.out.println(CLEAR);
        System.out.println("===================================");
        System.out.println("    WELCOME TO STUDENT DATABASE");
        System.out.println("===================================");

        System.out.println("1. ADD NEW STUDENT");
        System.out.println("2. DELETE STUDENT");
        System.out.println("3. SEARCH STUDENT");
        System.out.println("4. VIEW ALL STUDENTS");
        System.out.println("5. EXIT");

        System.out.print("Enter Your Option: ");

        switch (SCANNER.nextInt()) {
            case 1 -> {
                System.out.println(CLEAR);
                System.out.println("===================================");
                System.out.println("          ADD NEW STUDENT        ");
                System.out.println("===================================");

                enter:
                while (true) {
                    System.out.print("Enter Student Name: ");
                    SCANNER.skip("\n");
                    String studentName = SCANNER.nextLine().trim();

                    if (studentName.isEmpty() || studentName.isBlank()) {
                        System.out.println("\033[31mInvalid Name. Please Enter Again!\033[0m");
                        continue;
                    }

                    String studentId = String.format("S%03d", studentIdCounter++);

                    allIds += studentId + ",";

                    allNames += studentName + ",";

                    // Enter programming fundamentals mark
                    while (true) {
                        System.out.print("Enter Programming Fundamentals Mark: ");
                        int mark = SCANNER.nextInt();

                        if (mark < 0 || mark > 100) {
                            System.out.println("\033[31mInvalid Mark. Please Enter Again!\033[0m");
                        } else {

                            pFMarks += mark + ",";
                            break;
                        }
                    }

                    // Enter operating system mark
                    while (true) {
                        System.out.print("Enter Operating System Mark: ");
                        int mark = SCANNER.nextInt();

                        if (mark < 0 || mark > 100) {
                            System.out.println("\033[31mInvalid Mark. Please Enter Again!\033[0m");
                        } else {
                            oSMarks += mark + ",";
                            break;
                        }
                    }

                    System.out.println("\033[34mWhoow...Entered Name Successfully!\033[0m");
                    System.out.println("Student IDs: " + allIds);
                    System.out.println("Student Names: " + allNames);
                    System.out.println("Student PF MARKS: " + pFMarks);
                    System.out.println("Student OS MARKS: " + oSMarks);
                    System.out.print("Do you want to add Another Student? (\033[34mY\033[0m/\033[31mN\033[0m) ");

                    switch (SCANNER.next().toUpperCase()) {
                        case "Y":
                            continue enter;
                        case "N":
                            continue main;
                        default:
                            System.out.println("Enter Y / N: ");
                    }
                }
            }

            case 2 -> {
                //DELETE STUDENT
                System.out.println(CLEAR);
                System.out.println("===================================");
                System.out.println("          DELETE STUDENT        ");
                System.out.println("===================================");

                delete:
                while (true) {
                    SCANNER.skip("\n");
                    System.out.print("Enter Delete Student ID (S001): ");
                    String deletedId = SCANNER.nextLine().trim();

                    if (!allIds.contains(deletedId)) {
                        System.out.println("\033[31mInvalid Student ID\033[0m");
                        continue delete;
                    }
                    numberOfStudents = allIds.length() - allIds.replace(",", "").length();

                    String findId = "";
                    int commaIndexId = 0;
                    int count = 1;

                    for (int i = 0; i < numberOfStudents; i++) {
                        findId = allIds.substring(commaIndexId, allIds.indexOf(',', commaIndexId));
                        commaIndexId = allIds.indexOf(",", commaIndexId) + 1;


                        if (findId.equals(deletedId)) {
                            studentNumber = count;
                        } else {
                            count++;
                        }
                    }

                    commaIndexId = 0;
                    int startIndexId = 0;

                    for (int i = 0; i < studentNumber; i++) {
                        findId = allIds.substring(commaIndexId, allIds.indexOf(',', commaIndexId));
                        commaIndexId = allIds.indexOf(",", commaIndexId) + 1;
                        startIndexId += findId.length();
                    }

                    startIndexId = startIndexId - findId.length();
                    allIds = allIds.substring(0, startIndexId) + allIds.substring(startIndexId + 1 + findId.length());

                    String findName = "";
                    int startIndexName = 0;
                    int commaIndexName = 0;

                    for (int i = 0; i < studentNumber; i++) {

                        findName = allNames.substring(commaIndexName, allNames.indexOf(',', commaIndexName));
                        commaIndexName = allNames.indexOf(",", commaIndexName) + 1;
                        startIndexName += findName.length();
                    }
                    startIndexName = startIndexName - findName.length();
                    allNames = allNames.substring(0, startIndexName) + allNames.substring(startIndexName + 1 + findName.length());

                    String findMarksPf = "";
                    int commaIndexMarksPf = 0;
                    int startIndexMarksPF = 0;

                    for (int i = 0; i < studentNumber; i++) {

                        findMarksPf = pFMarks.substring(commaIndexMarksPf, pFMarks.indexOf(',', commaIndexMarksPf));
                        commaIndexMarksPf = pFMarks.indexOf(",", commaIndexMarksPf) + 1;
                        startIndexMarksPF += findMarksPf.length();
                    }

                    startIndexMarksPF = startIndexMarksPF - findMarksPf.length();
                    pFMarks = pFMarks.substring(0, startIndexMarksPF) + pFMarks.substring(startIndexMarksPF + 1 + findMarksPf.length());
                    String findMarkOOP = "";
                    int commaIndexMarksOS = 0;
                    int startIndexMarksOS = 0;

                    for (int i = 0; i < studentNumber; i++) {
                        findMarkOOP = oSMarks.substring(commaIndexMarksOS, oSMarks.indexOf(',', commaIndexMarksOS));
                        commaIndexMarksOS = oSMarks.indexOf(",", commaIndexMarksOS) + 1;
                        startIndexMarksOS += findMarkOOP.length();

                    }

                    startIndexMarksOS = startIndexMarksOS - findMarkOOP.length();
                    oSMarks = oSMarks.substring(0, startIndexMarksOS) + oSMarks.substring(startIndexMarksOS + 1 + findMarkOOP.length());

                    System.out.println("Student Deleted Successfully");
                    System.out.println("Student IDs: " + allIds);
                    System.out.println("Student Names: " + allNames);
                    System.out.println("Student PF MARKS: " + pFMarks);
                    System.out.println("Student OS MARKS: " + oSMarks);

                    System.out.print("Do you want to add Another Student? (\033[34mY\033[0m/\033[31mN\033[0m) ");

                    switch (SCANNER.next().toUpperCase()) {
                        case "Y":
                            continue delete;
                        case "N":
                            continue main;
                        default:
                            System.out.println("Enter Y / N: ");
                    }
                }
            }
            case 3 -> {
                //SEARCH STUDENT
                System.out.println(CLEAR);
                System.out.println("===================================");
                System.out.println("          SEARCH STUDENT        ");
                System.out.println("===================================");

                search:
                while (true){
                    System.out.println("Enter Student ID to Search: ");
                    String searchStu = SCANNER.next();

                    if (!allIds.contains(searchStu)) {
                        System.out.println("\033[31mInvalid Student ID\033[0m");
                        continue search;
                    }

                    numberOfStudents = allIds.length() - allIds.replace(",", "").length();

                    String findId = "";
                    int commaIndexId = 0;
                    int count = 1;

                    for (int i = 0; i < numberOfStudents; i++) {
                        findId = allIds.substring(commaIndexId, allIds.indexOf(',', commaIndexId));
                        commaIndexId = allIds.indexOf(",", commaIndexId) + 1;

                        if (findId.equals(searchStu)) {
                            studentNumber = count;
                        } else {
                            count++;
                        }
                    }
                    commaIndexId = 0;
                    for (int i = 0; i < studentNumber; i++) {
                        findId = allIds.substring(commaIndexId, allIds.indexOf(',', commaIndexId));
                        commaIndexId = allIds.indexOf(",", commaIndexId) + 1;
                    }

                    String findName = "";
                    int commaIndexName = 0;

                    for (int i = 0; i < studentNumber; i++) {

                        findName = allNames.substring(commaIndexName, allNames.indexOf(',', commaIndexName));
                        commaIndexName = allNames.indexOf(",", commaIndexName) + 1;
                    }


                    String findMarksPf = "";
                    int commaIndexMarksPf = 0;

                    for (int i = 0; i < studentNumber; i++) {

                        findMarksPf = pFMarks.substring(commaIndexMarksPf, pFMarks.indexOf(',', commaIndexMarksPf));
                        commaIndexMarksPf = pFMarks.indexOf(",", commaIndexMarksPf) + 1;

                    }
                    String findMarkOOP = "";
                    int commaIndexMarksOOP = 0;

                    for (int i = 0; i < studentNumber; i++) {
                        findMarkOOP = oSMarks.substring(commaIndexMarksOOP, oSMarks.indexOf(',', commaIndexMarksOOP));
                        commaIndexMarksOOP = oSMarks.indexOf(",", commaIndexMarksOOP) + 1;
                    }

                    System.out.println(STR."Student ID: \{findId}\nStudent Name: \{findName}\nMarks PF: \{findMarksPf}\nMarks OOP: \{findMarkOOP}");

                    System.out.print("Do you want to Search Another Student? (\033[34mY\033[0m/\033[31mN\033[0m) ");
                    switch (SCANNER.next().toUpperCase()) {
                        case "Y":
                            continue search;
                        case "N":
                            continue main;
                        default:
                            System.out.println("Enter Y / N: ");
                    }
                }
            }
            case 4->{
                System.out.println(CLEAR);
                System.out.println("=============================================");
                System.out.println("                ALL STUDENT DETAILS");
                System.out.println("=============================================");

                int nameWidth = 0;
                int totalWidth = 6;
                int averageWidth = 8;

                numberOfStudents = allIds.length() - allIds.replace(",", "").length();
                String findName = "";
                String findMarksPf = "";
                String findMarkOOP = "";

                int commaIndexName = 0;
                int commaIndexMarksPf = 0;
                int commaIndexMarksOOP = 0;

                int maxMarks = 0;
                int minMarks = 200;


                for (int i = 0; i < numberOfStudents; i++) {
                    findName = allNames.substring(commaIndexName, allNames.indexOf(',', commaIndexName));
                    findMarksPf = pFMarks.substring(commaIndexMarksPf, pFMarks.indexOf(',', commaIndexMarksPf));
                    findMarkOOP = oSMarks.substring(commaIndexMarksOOP, oSMarks.indexOf(',', commaIndexMarksOOP));
                    commaIndexName = allNames.indexOf(",", commaIndexName) + 1;
                    commaIndexMarksPf = pFMarks.indexOf(",", commaIndexMarksPf) + 1;
                    commaIndexMarksOOP = oSMarks.indexOf(",", commaIndexMarksOOP) + 1;

                    int total = Integer.parseInt(findMarksPf) + Integer.parseInt(findMarkOOP);
                    nameWidth = findName.length() > nameWidth ? findName.length() : nameWidth;
                    maxMarks = total > maxMarks ? total : maxMarks;
                    minMarks = total < minMarks ? total : minMarks;

                }

                String name = "";
                System.out.println("+".concat("-".repeat(5)).concat("+").concat("-".repeat(nameWidth + 2)).concat("+").concat("-".repeat(totalWidth)).concat("+").concat("-".repeat(averageWidth)).concat("+").concat("-".repeat(5)).concat("+"));
                System.out.printf("|%-5s", " ID");
                System.out.printf("|%-" + (nameWidth + 2) + "s", " NAME");
                System.out.printf("|%-" + totalWidth + "s", " TOTAL");
                System.out.printf("|%-" + averageWidth + "s", " AVERAGE");
                System.out.printf("|%-5s", " STAT");
                System.out.println("|");
                System.out.println("+".concat("-".repeat(5)).concat("+").concat("-".repeat(nameWidth + 2)).concat("+").concat("-".repeat(totalWidth)).concat("+").concat("-".repeat(averageWidth)).concat("+").concat("-".repeat(5)).concat("+"));

                String findId = "";

                int commaIndexId = 0;
                commaIndexMarksOOP = 0;
                commaIndexMarksPf = 0;
                commaIndexName = 0;

                for (int i = 0; i < numberOfStudents; i++) {

                    findId = allIds.substring(commaIndexId, allIds.indexOf(',', commaIndexId));
                    findName = allNames.substring(commaIndexName, allNames.indexOf(',', commaIndexName));
                    findMarksPf = pFMarks.substring(commaIndexMarksPf, pFMarks.indexOf(',', commaIndexMarksPf));
                    findMarkOOP = oSMarks.substring(commaIndexMarksOOP, oSMarks.indexOf(',', commaIndexMarksOOP));

                    double average = (Integer.parseInt(findMarksPf) + Integer.parseInt(findMarkOOP)) / 2.;
                    int total = Integer.parseInt(findMarksPf) + Integer.parseInt(findMarkOOP);


                    commaIndexId = allIds.indexOf(",", commaIndexId) + 1;
                    commaIndexName = allNames.indexOf(",", commaIndexName) + 1;
                    commaIndexMarksPf = pFMarks.indexOf(",", commaIndexMarksPf) + 1;
                    commaIndexMarksOOP = pFMarks.indexOf(",", commaIndexMarksOOP) + 1;

                    String idOut = String.format("|%-5s",
                            total == minMarks ?
                                    findId :
                                    total == maxMarks ?
                                            findId :
                                            findId);
                    System.out.print(idOut);

                    String nameOut = String.format("|%-" + (nameWidth + 2) + "s",
                            total == minMarks ?
                                    findName :
                                    total == maxMarks ?
                                            findName :
                                            findName);
                    System.out.print(nameOut);

                    String totalOut = String.format("|%-" + totalWidth + "s",
                            total == minMarks ?
                                    total :
                                    total == maxMarks ?
                                            total :
                                            String.valueOf(total));
                    System.out.print(totalOut);

                    String avgOut = String.format("|%-" + averageWidth + "s",
                            total == minMarks ?
                                    average :
                                    total == maxMarks ?
                                            average :
                                            String.valueOf(average));
                    System.out.print(avgOut);



                    String grade = average >= 75 ? " A" : average >= 65 ? " B" : average >= 55 ? " C" : average >= 45 ? " S" : " F";

                    String statOut = String.format("|%-5s",
                            total == minMarks ?
                                    STR."\033[31m \{grade}\s\s\033[0m" :
                                    total == maxMarks ?
                                            STR."\033[32m \{grade}\s\s\033[0m" :
                                            STR." \{grade}\s\s");
                    System.out.print(statOut);

                    System.out.println("|");

                }
                System.out.println("+".concat("-".repeat(5)).concat("+").concat("-".repeat(nameWidth + 2)).concat("+").concat("-".repeat(totalWidth)).concat("+").concat("-".repeat(averageWidth)).concat("+").concat("-".repeat(5)).concat("+"));
                System.out.println();

                System.out.println();

                System.out.println(STR."MAX: \{maxMarks}");
                System.out.println(STR."MIN: \{minMarks}");
                System.out.println(STR."Name Width: \{nameWidth}");

                System.out.print("Do you want to Go back to Main Menu? (\033[34mY\033[0m ");
                switch (SCANNER.next().toUpperCase()) {
                    case "Y":
                        continue main;

                    default:
                        System.out.println("Enter Y to Go Back: ");
                }
            }
            case 5 ->{
                System.exit(1);
            }
            default -> {
                System.out.println("Enter Valid Input!");
            }
        }
    }
}




