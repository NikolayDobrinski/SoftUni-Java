package softuni.advanced.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**Description:
 * We have a robotics factory with a current project to process robots on a production line.
 * Each robot has a different processing time required to process a product.
 * When the robot is free, it must take a product to be processed and register its name,
 * product and time to start processing. Each robot processes a product coming from the production line.
 * The product comes off the line every second (so the first product must appear in [start time + 1 second]).
 * If a product crosses the line and there is no free robot to pick it up,
 * it must be queued at the end of the line again. The robots stand in line in the order of their appearance.
 */

public class Robotics {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        List<String> robots = Arrays.stream(scan.nextLine().split(";"))
                .collect(Collectors.toList());

        String[] names = new String[robots.size()];
        int[] processTime = new int[robots.size()];

        for (int i = 0; i < robots.size(); i++) {
            String[] tokens = robots.get(i).split("-");
            String name = tokens[0];
            names[i] = name;
            int time = Integer.parseInt(tokens[1]);
            processTime[i] = time;

        }

        String startTime = scan.nextLine();

        ArrayDeque<String> productsQueue = new ArrayDeque<>();

        String inputProduct;

        while (!"End".equals(inputProduct = scan.nextLine())) {
            productsQueue.offer(inputProduct);
        }

        String[] timeData = startTime.split(":");
        int hours = Integer.parseInt(timeData[0]);
        int minutes = Integer.parseInt(timeData[1]);
        int seconds = Integer.parseInt(timeData[2]);

        int startTimeInSeconds = hours * 3600 + minutes * 60 + seconds;

        int[] robotsWorkLeft = new int[robots.size()];

        while (!productsQueue.isEmpty()) {
            startTimeInSeconds++;
            String product = productsQueue.poll();
            int index = -1;

            for (int i = 0; i < robotsWorkLeft.length; i++) {
                if (robotsWorkLeft[i] > 0) {
                    robotsWorkLeft[i]--;
                }
                if (robotsWorkLeft[i] == 0 && index == -1) {
                    index = i;
                }
            }

                if (index != -1) {
                    robotsWorkLeft[index] = processTime[index];
                    System.out.println(printRobotData(names[index], product, startTimeInSeconds));
                } else {
                    productsQueue.offer(product);
                }
            }
        }

    private static String printRobotData(String name, String product, int beginTime) {

        long seconds = beginTime % 60;
        long minutes = (beginTime / 60) % 60;
        long hours = (beginTime / (60 * 60)) % 24;

        String time = String.format("%02d:%02d:%02d", hours, minutes, seconds);

        return String.format("%s - %s [%s]", name, product, time);
    }
}
