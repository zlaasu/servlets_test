package org.zlasu.consoleInterface.print;

import org.zlasu.consoleInterface.Colors;
import org.zlasu.model.exercise.Exercise;
import org.zlasu.model.exercise.ExerciseDao;
import org.zlasu.libs.readConsole.ReadSystemConsole;

import java.util.List;
import java.util.Scanner;

public class PrintExercise {

    public static void create(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        String title = ReadSystemConsole.readString(scanner,"Give new title of the exercise...");
        String description = ReadSystemConsole.readString(scanner,"Give new description of the exercise...");

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = new Exercise();
        exercise.setTitle(title);
        exercise.setDescription(description);
        exerciseDao.create(exercise);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void update(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int id = ReadSystemConsole.readPositiveInt(scanner, "Chose ID of the group to update...");
        String title = ReadSystemConsole.readString(scanner,"Give new title of the group...");
        String description = ReadSystemConsole.readString(scanner,"Give new description of the exercise...");

        ExerciseDao exerciseDao = new ExerciseDao();
        Exercise exercise = exerciseDao.read(id);
        exercise.setTitle(title);
        exercise.setDescription(description);
        exerciseDao.update(exercise);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void read() {
        ExerciseDao exerciseDao = new ExerciseDao();
        List<Exercise> exercises = exerciseDao.findAll();

        String[] header = new String[] {"id", "title", "description"};
        String[][] table = new String[exercises.size()][3];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][0] = String.valueOf(exercises.get(i).getId());
                table[i][1] = exercises.get(i).getTitle();
                table[i][2] = exercises.get(i).getDescription();
            }
        }

        System.out.println(PrintFlipTable.of(header, table));
    }

    public static void delete(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int idToDelete = ReadSystemConsole.readPositiveInt(scanner, "Chose ID to delete...");


        ExerciseDao exerciseDao = new ExerciseDao();
        exerciseDao.delete(idToDelete);

        System.out.println(Colors.ANSI_RESET);
    }
}
