package org.zlasu.consoleInterface;

import org.zlasu.consoleInterface.print.*;

import java.util.Scanner;

public class TerminalInterface {
    private static final int TABLE_EXIT = 0;
    private static final int TABLE_USERS = 1;
    private static final int TABLE_USERS_GROUP = 2;
    private static final int TABLE_EXERCISE = 3;
    private static final int TABLE_SOLUTION = 4;

    private static final int CRUD_BACK = 0;
    private static final int CRUD_CREATE = 1;
    private static final int CRUD_READ = 2;
    private static final int CRUD_UPDATE = 3;
    private static final int CRUD_DELETE = 4;


    public static void run() {
        Scanner scanner = new Scanner(System.in);
        int pickedResource = -1;
        int pickecCURDAction;

        while (pickedResource != TABLE_EXIT) {
            pickedResource = PrintMenus.getUserPickResource(scanner);
            pickecCURDAction = -1;

            if (pickedResource == TABLE_EXIT) {
                PrintMenus.clearScreen();
                break;
            }

            while (pickecCURDAction != CRUD_BACK) {
                pickecCURDAction = PrintMenus.getUserCRUDAction(scanner);

                if (pickecCURDAction == CRUD_BACK) {
                    PrintMenus.clearScreen();
                    break;
                }

                resourceRouter(scanner, pickedResource, pickecCURDAction);
            }
        }
        System.out.println();
        System.out.println("     THE END");
    }

    private static void resourceRouter(Scanner scanner, int pickedResource, int pickecCURDAction) {
        switch (pickedResource) {
            case TABLE_USERS:
                usersRouter(scanner, pickecCURDAction);
                break;
            case TABLE_USERS_GROUP:
                usersGroupRouter(scanner, pickecCURDAction);
                break;
            case TABLE_EXERCISE:
                exerciseRouter(scanner, pickecCURDAction);
                break;
            case TABLE_SOLUTION:
                solutionRouter(scanner, pickecCURDAction);
                break;
        }

    }

    private static void usersRouter(Scanner scanner, int pickecCURDAction) {
        switch (pickecCURDAction) {
            case CRUD_CREATE:
                PrintUser.create(scanner);
                break;
            case CRUD_READ:
                PrintUser.read();
                break;
            case CRUD_UPDATE:
                PrintUser.update(scanner);
                break;
            case CRUD_DELETE:
                PrintUser.delete(scanner);
                break;
        }
    }

    private static void usersGroupRouter(Scanner scanner, int pickecCURDAction) {
        switch (pickecCURDAction) {
            case CRUD_CREATE:
                PrintUserGroup.create(scanner);
                break;
            case CRUD_READ:
                PrintUserGroup.read();
                break;
            case CRUD_UPDATE:
                PrintUserGroup.update(scanner);
                break;
            case CRUD_DELETE:
                PrintUserGroup.delete(scanner);
                break;
        }
    }

    private static void exerciseRouter(Scanner scanner, int pickecCURDAction) {
        switch (pickecCURDAction) {
            case CRUD_CREATE:
                PrintExercise.create(scanner);
                break;
            case CRUD_READ:
                PrintExercise.read();
                break;
            case CRUD_UPDATE:
                PrintExercise.update(scanner);
                break;
            case CRUD_DELETE:
                PrintExercise.delete(scanner);
                break;
        }
    }

    private static void solutionRouter(Scanner scanner, int pickecCURDAction) {
        switch (pickecCURDAction) {
            case CRUD_CREATE:
                PrintSolution.create(scanner);
                break;
            case CRUD_READ:
                PrintSolution.read();
                break;
            case CRUD_UPDATE:
                PrintSolution.update(scanner);
                break;
            case CRUD_DELETE:
                PrintSolution.delete(scanner);
                break;
        }
    }
}