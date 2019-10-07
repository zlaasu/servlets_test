package org.zlasu.consoleInterface.print;

import org.zlasu.consoleInterface.Colors;
import org.zlasu.model.userGroup.UserGroup;
import org.zlasu.model.userGroup.UserGroupDao;
import org.zlasu.libs.readConsole.ReadSystemConsole;

import java.util.List;
import java.util.Scanner;

public class PrintUserGroup {

    public static void create(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        String name = ReadSystemConsole.readString(scanner,"Give new name of the group...");

        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup userGroup = new UserGroup();
        userGroup.setName(name);
        userGroupDao.create(userGroup);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void update(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int id = ReadSystemConsole.readPositiveInt(scanner, "Chose ID of the group to update...");
        String name = ReadSystemConsole.readString(scanner,"Give new name of the group...");

        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup userGroup = userGroupDao.read(id);
        userGroup.setName(name);
        userGroupDao.update(userGroup);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void read() {
        UserGroupDao userGroupDao = new UserGroupDao();
        List<UserGroup> userGroups = userGroupDao.findAll();

        String[] header = new String[] {"id", "name"};
        String[][] table = new String[userGroups.size()][2];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][0] = String.valueOf(userGroups.get(i).getId());
                table[i][1] = userGroups.get(i).getName();
            }
        }

        System.out.println(PrintFlipTable.of(header, table));
    }

    public static void delete(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int idToDelete = ReadSystemConsole.readPositiveInt(scanner, "Chose ID to delete...");

        UserGroupDao userGroupDao = new UserGroupDao();
        userGroupDao.delete(idToDelete);

        System.out.println(Colors.ANSI_RESET);
    }
}
