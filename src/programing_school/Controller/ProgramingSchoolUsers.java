package programing_school.Controller;

import programing_school.Dao.UsersDao;
import programing_school.Entity.Users;
import programing_school.service.ScannerService;

import java.util.List;


public class ProgramingSchoolUsers {
    public static void main(String[] args) {

        choseWhatToDo();


    }

    private static void printUsersTable() {
        List<Users> usersList = UsersDao.allUsers();
        for (Users users : usersList)
            System.out.println(users);
    }

    private static void choseWhatToDo() {
        System.out.println("\n" + "wybierz jedną z opcji: " + "\n" + " add - dodanie użytkownika" + "\n" + " edit - edycja użytkownika"
                + "\n" + " delete - usunięcie użytkownika" + "\n" + " quit - zakończenie programu");
        scanner:
        while (true) {
            System.out.println("wybierz co chcesz zrobić : ");
            String operation = ScannerService.getString();
            switch (operation) {
                case "add":
                    addUser();
                    break;
                case "edit":
                    editUser();
                    break;
                case "delete":
                    deleteUser();
                    break;
                case "quit":
                    break scanner;
            }
        }
    }

    private static void addUser() {

        System.out.println("podaj username : ");
        String username = ScannerService.getString();
        System.out.println("podaj email : ");
        String email = ScannerService.getString();
        System.out.println("podaj hasło : ");
        String password = ScannerService.getString();
        System.out.println(" Podaj user_group_id : ");
        Integer user_group_id = ScannerService.getInt("podaj poprawna wartosc liczbowa");

        Users user = new Users();
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUser_group_id(user_group_id);

        UsersDao.create(user);
    }

    private static void editUser() {
        System.out.println("podaj id");
        Integer id = ScannerService.getInt("podaj poprawna wartosc liczbowa");
        System.out.println("podaj username : ");
        String username = ScannerService.getString();
        System.out.println("podaj email : ");
        String email = ScannerService.getString();
        System.out.println("podaj hasło : ");
        String password = ScannerService.getString();
        System.out.println(" Podaj user_group_id : ");
        Integer user_group_id = ScannerService.getInt("podaj poprawna wartosc liczbowa");

        Users user = new Users();
        user.setId(id);
        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUser_group_id(user_group_id);

        UsersDao.update(user);
    }

    private static void deleteUser() {
        System.out.println("podaj id");
        Integer id = ScannerService.getInt("podaj wartosc liczbowa");

        UsersDao.delete(id);
    }
}
