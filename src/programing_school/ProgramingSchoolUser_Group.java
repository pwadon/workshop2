package programing_school;

import programing_school.Dao.UserGroupDao;
import programing_school.Entity.UserGroup;

import java.util.List;

public class ProgramingSchoolUser_Group {
    public static void main(String[] args) {

        printUser_GroupTable();
        choseWhatToDo();
    }

    private static void printUser_GroupTable() {
        List<UserGroup> userGroupList = UserGroupDao.findAll();
        for (UserGroup userGroup : userGroupList)
            System.out.println(userGroup);
    }

    private static void choseWhatToDo() {
        System.out.println("\n" + "wybierz jedną z opcji: " + "\n" + " add - dodanie grupy" + "\n" + " edit - edycja grupy"
                + "\n" + " delete - usunięcie grupy" + "\n" + " quit - zakończenie programu");
        scanner:
        while (true) {
            System.out.println("wybierz co chcesz zrobić : ");
            String operation = ScannerService.getString();
            switch (operation) {
                case "add":
                    addGroup();
                    break;
                case "edit":
                    editGroup();
                    break;
                case "delete":
                    deleteGroup();
                    break;
                case "quit":
                    break scanner;
            }
        }
    }

    private static void addGroup() {

        System.out.println("podaj nazwe : ");
        String name = ScannerService.getString();

        UserGroup group = new UserGroup();
        group.setName(name);

        UserGroupDao.create(group);
    }

    private static void editGroup() {
        System.out.println("podaj id");
        int id = ScannerService.getInt("podaj poprawna wartosc liczbowa");
        System.out.println("podaj name : ");
        String name = ScannerService.getString();

        UserGroup group = new UserGroup();
        group.setId(id);
        group.setName(name);

        UserGroupDao.update(group);
    }

    private static void deleteGroup() {
        System.out.println("podaj id");
        int id = ScannerService.getInt("podaj wartosc liczbowa");
        UserGroupDao.delete(id);
    }
}
