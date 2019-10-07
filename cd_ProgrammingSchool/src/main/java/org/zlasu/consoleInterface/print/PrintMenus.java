package org.zlasu.consoleInterface.print;

import org.zlasu.consoleInterface.Colors;
import org.zlasu.libs.readConsole.ReadSystemConsole;

import java.util.Scanner;

public class PrintMenus {

    public static int getUserCRUDAction(Scanner scanner) {
        System.out.print(Colors.ANSI_BRIGHT_WHITE + Colors.ANSI_BRIGHT_BG_BLUE);
        System.out.println(" +--------------------+ ");
        System.out.println(" | Chose CRUD action: | ");
        System.out.println(" +--------------------+ ");
        System.out.print(Colors.ANSI_RESET + Colors.ANSI_BLUE);
        System.out.println("(0) - ...back...");
        System.out.println("(1) - create");
        System.out.println("(2) - read");
        System.out.println("(3) - update");
        System.out.println("(4) - delete");

        System.out.print(Colors.ZL_CHOSE);
        int cRUDAction = 999;
        while (!(cRUDAction < 5)) {
            cRUDAction = ReadSystemConsole.readPositiveInt(scanner, "chose [0/1/2/3/4]...");
        }
        System.out.println(Colors.ANSI_RESET);

        return cRUDAction;
    }

    public static int getUserPickResource(Scanner scanner) {
        System.out.print(Colors.ANSI_BRIGHT_WHITE + Colors.ANSI_BG_BLUE);
        System.out.println(" +----------------------------+ ");
        System.out.println(" | Chose resource for action: | ");
        System.out.println(" +----------------------------+ ");
        System.out.print(Colors.ANSI_RESET + Colors.ANSI_BLUE);
        System.out.println("(0) - ...exit...");
        System.out.println("(1) - resource 'users'");
        System.out.println("(2) - resource 'users_group'");
        System.out.println("(3) - resource 'exercise'");
        System.out.println("(4) - resource 'solution'");

        System.out.print(Colors.ZL_CHOSE);
        int tableMenuAction = 999;
        while (!(tableMenuAction < 5)) {
            tableMenuAction = ReadSystemConsole.readPositiveInt(scanner, "chose [0/1/2/3/4]...");
        }
        System.out.println(Colors.ANSI_RESET);

        return tableMenuAction;
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
