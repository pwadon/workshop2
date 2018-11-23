package programing_school;

import programing_school.Dao.ExerciseDao;
import programing_school.Dao.SolutionDao;
import programing_school.Dao.UsersDao;
import programing_school.Entity.Users;
import programing_school.Entity.exercise;
import programing_school.Entity.solution;

import java.nio.channels.DatagramChannel;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class ProgramingSchoolSolution {
    public static void main(String[] args) {

        choseWhatToDo();

    }

    private static void choseWhatToDo() {
        System.out.println("\n" + "wybierz jedną z opcji: " + "\n" + " add - przypisanie zadania do uzytkownika" + "\n"
                + " view - przeglądanie rozwiązań danego użytkownika" + "\n" + " quit - zakończenie programu");
        scanner:
        while (true) {
            System.out.println("wybierz co chcesz zrobić : ");
            String operation = ScannerService.getString();
            switch (operation) {
                case "add":
                    addSolution();
                    break;
                case "view":
                    view();
                    break;
                case "quit":
                    break scanner;
            }
        }
    }

    private static void addSolution() {

        List<Users> usersList = UsersDao.allUsers();
        for (Users users : usersList)
            System.out.println(users);

        System.out.println(("Podaj id użytkownika"));
        int userId = ScannerService.getInt("podaj wartosc int");


        List<exercise> exerciseList = ExerciseDao.allExercises();
        for (exercise exercises : exerciseList)
            System.out.println(exercises);

        System.out.println("Podaj id zadania");
        int exerciseId = ScannerService.getInt("podaj wartośc int");

        Date date = new Date();

        solution solution = new solution();
        solution.setExercise_id(exerciseId);
        solution.setUsers_id(userId);
        solution.setCreated(date.toLocaleString());

        SolutionDao.create(solution);

    }

    private static void view() {
        System.out.println("podaj id użytkownika którego rozwiązania chcesz zobaczyc");
        int id = ScannerService.getInt("podaj poprawna wartosc liczbowa");

        List<solution> solutionList = SolutionDao.loadALLByUserId(id);
        for(solution solution : solutionList)
            System.out.println(solution);
    }
}
