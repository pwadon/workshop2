package programing_school;

import programing_school.Dao.ExerciseDao;
import programing_school.Entity.exercise;

import java.util.List;

public class ProgramingSchoolExercise {
    public static void main(String[] args) {


       printExerciseTable();
        choseWhatToDo();
    }




    private static void printExerciseTable() {
        List<exercise> exerciseList = ExerciseDao.allExercises();
        for (exercise ex : exerciseList)
            System.out.println(ex);
    }

    private static void choseWhatToDo() {
        System.out.println("\n" + "wybierz jedną z opcji: " + "\n" + " add - dodanie zadania" + "\n" + " edit - edycja zadania"
                + "\n" + " delete - usunięcie zadania" + "\n" + " quit - zakończenie programu");
        scanner:
        while (true) {
            System.out.println("wybierz co chcesz zrobić : ");
            String operation = ScannerService.getString();
            switch (operation) {
                case "add":
                    addExercise();
                    break;
                case "edit":
                    editExercise();
                    break;
                case "delete":
                    deleteExercise();
                    break;
                case "quit":
                    break scanner;
            }
        }
    }

    private static void addExercise() {

        System.out.println("podaj nazwe : ");
        String file = ScannerService.getString();
        System.out.println("podaj opis : ");
        String description = ScannerService.getString();

        exercise exercise = new exercise();
        exercise.setFile(file);
        exercise.setDescription(description);

        ExerciseDao.create(exercise);
    }

    private static void editExercise() {
        System.out.println("podaj id");
        int id = ScannerService.getInt("podaj poprawna wartosc liczbowa");
        System.out.println("podaj file name : ");
        String file = ScannerService.getString();
        System.out.println("podaj description : ");
        String description = ScannerService.getString();

        exercise exercise = new exercise();
        exercise.setId(id);
        exercise.setFile(file);
        exercise.setDescription(description);

        ExerciseDao.update(exercise);
    }

    private static void deleteExercise() {
        System.out.println("podaj id");
        Integer id = ScannerService.getInt("podaj wartosc liczbowa");

        ExerciseDao.delete(id);
    }
}
