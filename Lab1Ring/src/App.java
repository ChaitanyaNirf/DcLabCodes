import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class App {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception {

        System.out.println("Enter the number of processes: ");
        int n = scanner.nextInt();
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Node> ring = new ArrayList<>();
        for(int i=0;i<n;i++){
            Node temp = new Node();
            System.out.println("Enter id of the process: ");
            temp.id = scanner.nextInt();
            System.out.println("Enter the status of the process: ");
            temp.status = scanner.nextInt();
            ring.add(temp);

            map.put(i,temp.id);
        }



        System.out.println("Which process should start the election, enter it's id: ");
        int pinitiate = scanner.nextInt();

        List<Integer> carryId = new ArrayList<>();
        int index = -1;

        for(int i =0;i<n;i++){
            if(pinitiate == map.get(i)){
                index = i;
                break;
            }
        }
        carryId.add(pinitiate);



        for(int i=(index+1)%n;i!=index;i=(i+1)%n){
            if(ring.get(i).status == 1){
                System.out.println("List passed on to process :" + map.get(i)+" "+ carryId);
                carryId.add(ring.get(i).id);
                System.out.println(carryId);
            }

            System.out.println("Process is down, so skipped");
        }

        System.out.println("List passed till process id: "+ map.get(pinitiate) + " "+ carryId);
        System.out.println(Collections.max(carryId) +" announces itself as coordinator");






    }
}
