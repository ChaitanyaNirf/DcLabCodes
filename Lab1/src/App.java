import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Enter the number of processes: ");
        int n = scanner.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[] electionStatus = new boolean[n];
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " Is this process active ? 1/0: ");
            int flag = scanner.nextInt();
            if (flag == 1) {
                map.put(i + 1, 1);
            } else if (flag == 0) {
                map.put(i + 1, 0);
            }
        }

        // Printing the hashmap to see the status of the processes
        for (int i = 0; i < n; i++) {
            System.out.println(i + 1 + " " + map.get(i + 1));
        }

        System.out.println("Which process should initiate the election?");
        int pInitiate = scanner.nextInt();
        ArrayList<Integer> actProcesses = new ArrayList<>();
        election(map, electionStatus, pInitiate, actProcesses);

        // Now when the process is initiated, it will send an election message to all
        // the processes above it
        // int actpcount = 0;
        // int coordinator = Integer.MIN_Value;
        // for(int i=pInitiate+1; i<=n;i++){
        // if(map.get(i) == 1){
        // System.out.println("Received an message from " + i );
        // áctpcount++;
        // coordinator = i;
        // }else{
        // System.out.println("No message received from" + i);
        // }
        // }

        // announces itself as a coordinator tells the processes lower than itself
        // if(actpcount == 0){
        // for(int i=1;i<coordinator;i++){
        // System.out.println(coordinator + "Announces itself as an coordinator to " +
        // i);
        // }
        // }
        // else{
        int coordinator = 0;
        for (int i = 0; i < actProcesses.size(); i++) {
            System.out.println("Election started by :" + actProcesses.get(i));
            coordinator = actProcesses.get(i);
            election(map, electionStatus, actProcesses.get(i), new ArrayList<Integer>());
        }
        for (int i = 1; i < coordinator; i++) {
            System.out.println(coordinator + " Announces itself as an coordinator to " + i);
        }
    }

    public static void election(HashMap<Integer, Integer> map, boolean[] electionStatus, int pInitiate,
            ArrayList<Integer> actProcesses) {

        // if (electionStatus[pInitiate] == true) {
        // System.out.println("Election already started by " + pInitiate);
        // return;
        // }
        electionStatus[pInitiate] = true;
        int actpcount = 0;
        // int coordinator = 0;
        for (int i = pInitiate + 1; i <= electionStatus.length; i++) {
            if (map.get(i) == 1) {
                System.out.println("Received an message from " + i);
                // System.out.println("Election started by " + i);
                if (electionStatus[i] == false) {
                    System.out.println("Election started by " + i);
                    electionStatus[i] = true;
                } else {
                    System.out.println("---Election already started by " + i);
                }
                actpcount++;
                // coordinator = i;
                actProcesses.add(i);
            } else {
                System.out.println("No message received from " + i);
            }
        }

        System.out.println();
        System.out.println(actpcount + " no of active processes");
        System.out.println(actProcesses);
        System.out.println();
        // if(actpcount == 0){
        // for(int i=1;i<coordinator;i++){
        // System.out.println(coordinator + "Announces itself as an coordinator to " +
        // i);
        // }

        // if (actProcesses.size() == 1) {
        // // int coordinator = actProcesses.get(0);
        // for (int i = 1; i < coordinator; i++) {
        // System.out.println(coordinator + " Announces itself as an coordinator to " +
        // i);
        // }
        // }

    }
}
