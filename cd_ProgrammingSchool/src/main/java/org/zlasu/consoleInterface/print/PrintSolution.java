package org.zlasu.consoleInterface.print;

import org.zlasu.consoleInterface.Colors;
import org.zlasu.model.solution.Solution;
import org.zlasu.model.solution.SolutionDao;
import org.zlasu.libs.readConsole.ReadSystemConsole;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrintSolution {

    public static void create(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        String description = ReadSystemConsole.readString(scanner, "Give new description...");

        SolutionDao solutionDao = new SolutionDao();
        Solution solution = new Solution();

        solution.setDescription(description);
        solution.setCreated(new Date());
        solution.setUpdated(new Date());

//        if (userGroup != null) {
//            user.setUserGroup(userGroup);
//        }
        solutionDao.create(solution);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void update(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int id = ReadSystemConsole.readPositiveInt(scanner, "Chose ID of the solution to update...");
        String description = ReadSystemConsole.readString(scanner, "Give new description...");

        SolutionDao solutionDao = new SolutionDao();
        Solution solution = solutionDao.read(id);

        solution.setDescription(description);
        solution.setUpdated(new Date());
        solution.setCreated(solution.getCreated());

//        if (userGroup != null) {
//            user.setUserGroup(userGroup);
//        }
        solutionDao.update(solution);

        System.out.println(Colors.ANSI_RESET);
    }

    public static void read() {
        SolutionDao solutionDao = new SolutionDao();;
        List<Solution> solutions = solutionDao.findAll();

        String[] header = new String[]{"id", "exercise_id", "user_id", "created", "updated", "description"};
        String[][] table = new String[solutions.size()][6];

        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table[i].length; j++) {
                table[i][0] = String.valueOf(solutions.get(i).getId());
                if (solutions.get(i).getExercise() != null) {
                    table[i][1] = String.valueOf(solutions.get(i).getExercise().getId());
                } else {
                    table[i][1] = "null";
                }
                if (solutions.get(i).getUser() != null) {
                    table[i][2] = String.valueOf(solutions.get(i).getUser().getId());
                } else {
                    table[i][2] = "null";
                }
                table[i][3] = solutions.get(i).getCreated().toString();
                table[i][4] = solutions.get(i).getUpdated().toString();
                table[i][5] = solutions.get(i).getDescription();
            }
        }

        System.out.println(PrintFlipTable.of(header, table));
    }

    public static void delete(Scanner scanner) {
        System.out.print(Colors.ZL_CHOSE);
        int idToDelete = ReadSystemConsole.readPositiveInt(scanner, "Chose ID to delete...");

        SolutionDao solutionDao = new SolutionDao();
        solutionDao.delete(idToDelete);

        System.out.println(Colors.ANSI_RESET);
    }
}
