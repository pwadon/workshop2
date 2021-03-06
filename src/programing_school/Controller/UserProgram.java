package programing_school.Controller;

import programing_school.Dao.SolutionDao;
import programing_school.Entity.solution;
import programing_school.service.ScannerService;

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
                        add(id);
                        break;
                    case "view":
                        view(id);
                        break;
                    case "quit":
                        break scanner;
                }
            }
        }
        private static void add(int id) {
            List<solution> solutionList = SolutionDao.loadALLByUserId(id);
            for(solution solution : solutionList)
                if (solution.getDescription() == null)
                    System.out.println(solution);
            System.out.println(("Podaj id zadania"));
            int exercise_Id = ScannerService.getInt("podaj wartosc int");
            solution solutioncheck = SolutionDao.SelectSolutionByUserAndExerciseId(id,exercise_Id);
            if(solutioncheck.getDescription()==null)
            {
                System.out.println("Podaj rozwiązanie zadania");
                String description = ScannerService.getString();
                Date date = new Date();
                solution solution = new solution();
                solution.setExercise_id(exercise_Id);
                solution.setDescription(description);
                solution.setCreated(date.toLocaleString());
                SolutionDao.update(solution);
            }
            else System.out.println("rozwiazanie juz zostalo dodane");
        }
        private static void view(int id) {
            List<solution> solutionList = SolutionDao.loadALLByUserId(id);
            for(solution solution : solutionList)
                System.out.println(solution);
        }
    }