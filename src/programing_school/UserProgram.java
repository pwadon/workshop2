package programing_school;

import programing_school.Dao.ExerciseDao;
import programing_school.Dao.SolutionDao;
import programing_school.Dao.UsersDao;
import programing_school.Entity.Users;
import programing_school.Entity.exercise;
import programing_school.Entity.solution;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class UserProgram {
    public static void main(String[] args) {

        choseWhatToDo();

    }

    private static void choseWhatToDo() {

        Scanner scan = new Scanner(System.in);
        System.out.println("podaj swoje id");

        while(!scan.hasNextInt()){
            System.out.println("podaj swoje id");
            scan.next();
        }
        int id = scan.nextInt();

        System.out.println("\n" + "wybierz jedną z opcji: " + "\n" + " add - dodanie rozwiązania" + "\n"
                + " view - przeglądanie swoich rozwiązań" + "\n" + " quit - zakończenie programu");
        scanner:
        while (true) {
            System.out.println("wybierz co chcesz zrobić : ");
            String operation = ScannerService.getString();
            switch (operation) {
                case "add":
                    add();
                    break;
                case "view":
                    view();
                    break;
                case "quit":
                    break scanner;
            }
        }
    }

//    private static void choseWhatToDo() {
//        System.out.println("\n" + "wybierz jedną z opcji: " + "\n" + " add - dodanie rozwiązania" + "\n"
//                + " view - przeglądanie swoich rozwiązań" + "\n" + " quit - zakończenie programu");
//        scanner:
//        while (true) {
//            System.out.println("wybierz co chcesz zrobić : ");
//            String operation = ScannerService.getString();
//            switch (operation) {
//                case "add":
//                    add();
//                    break;
//                case "view":
//                    view();
//                    break;
//                case "quit":
//                    break scanner;
//            }
//        }
//    }

    private static void add() {

        List<solution> solutions = SolutionDao.allSolutions();
        for (solution solution : solutions) {
            if (solution.getDescription() == null) {
                System.out.println(solution);
            }
        }


        System.out.println(("Podaj id zadania"));
        int exercise_Id = ScannerService.getInt("podaj wartosc int");

        System.out.println("Podaj rozwiązanie zadania");
        String description =ScannerService.getString();

        solution solution = new solution();
        solution.setId(exercise_Id);
        solution.setDescription(description);

        SolutionDao.update(solution);

    }

    private static void view() {
        System.out.println("podaj id aby zobaczyc swoje rozwiazania");
        int id = ScannerService.getInt("podaj poprawna wartosc liczbowa");

        System.out.println(SolutionDao.SelectSolutionById(id));
    }
}
