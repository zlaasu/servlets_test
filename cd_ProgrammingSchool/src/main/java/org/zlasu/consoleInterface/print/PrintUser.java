package org.zlasu.consoleInterface.print;

import org.zlasu.consoleInterface.Colors;
import org.zlasu.model.user.User;
import org.zlasu.model.user.UserDao;
import org.zlasu.model.userGroup.UserGroup;
import org.zlasu.model.userGroup.UserGroupDao;
import org.zlasu.libs.readConsole.ReadSystemConsole;

import java.util.List;
import java.util.Scanner;

public class PrintUser {

    public static void create(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        String username = ReadSystemConsole.readString(scanner, "Give new username...");
        String email = ReadSystemConsole.readString(scanner, "Give new email...");
        String password = ReadSystemConsole.readString(scanner, "Give new password...");
        int groupID = ReadSystemConsole.readPositiveInt(scanner, "Give new groupID...");

        UserDao userDao = new UserDao();
        User user = new User();
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup userGroup = userGroupDao.read(groupID);

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        if (userGroup != null) {
            user.setUserGroup(userGroup);
        }
        userDao.create(user);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void update(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int id = ReadSystemConsole.readPositiveInt(scanner, "Chose ID of the user to update...");
        String username = ReadSystemConsole.readString(scanner, "Give new username...");
        String email = ReadSystemConsole.readString(scanner, "Give new email...");
        String password = ReadSystemConsole.readString(scanner, "Give new password...");
        int groupID = ReadSystemConsole.readPositiveInt(scanner, "Give new groupID...");

        UserDao userDao = new UserDao();
        User user = userDao.read(id);
        UserGroupDao userGroupDao = new UserGroupDao();
        UserGroup userGroup = userDao.read(id).getUserGroup();

        user.setUsername(username);
        user.setEmail(email);
        user.setPassword(password);
        user.setUserGroup(userGroup);

        userDao.update(user);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void read() {
        UserDao userDao = new UserDao();
        List<User> users = userDao.findAll();

        String[] header = new String[]{"id", "user_group_id", "username", "email", "password"};
        String[][] table = new String[users.size()][5];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][0] = String.valueOf(users.get(i).getId());
                if (users.get(i).getUserGroup() != null) {
                    table[i][1] = String.valueOf(users.get(i).getUserGroup().getId());
                } else {
                    table[i][1] = "null";
                }
                table[i][2] = users.get(i).getUsername();
                table[i][3] = users.get(i).getEmail();
                table[i][4] = users.get(i).getPassword();
            }
        }

        System.out.println(PrintFlipTable.of(header, table));
    }

    public static void delete(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int idToDelete = ReadSystemConsole.readPositiveInt(scanner, "Chose ID to delete...");

        UserDao userDao = new UserDao();
        userDao.delete(idToDelete);

        System.out.println(Colors.ANSI_RESET);
    }
}
