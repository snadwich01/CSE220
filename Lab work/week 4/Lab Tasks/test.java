import java.util.Scanner;

public class WRMTester {

    public static void printOptions() {
        System.out.println("==Choose an Option==");
        System.out.println("1. RegisterPatient()");
        System.out.println("2. ServePatient()");
        System.out.println("3. CancelAll()");
        System.out.println("4. CanDoctorGoHome()");
        System.out.println("5. ShowAllPatient()");
        System.out.println("6. ReverseTheLine()");
        System.out.println("7. exit");
        System.out.println("=====================");
    }

    //after each operation you can choose option 5
    //to check whether your operation was correct or not
    public static void main(String[] args) {
        System.out.println("**Welcome to Waiting Room Management System**");

        Scanner sc = new Scanner(System.in);
        WRM wrm = new WRM();

        while (true) {
            printOptions();
            System.out.print("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("executing RegisterPatient()...");
                    System.out.print("Enter ID: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Enter Blood group: ");
                    String bloodGroup = sc.nextLine();
                    wrm.registerPatient(id, name, age, bloodGroup);
                    break;

                case "2":
                    System.out.println("executing ServePatient()...");
                    wrm.servePatient();
                    break;

                case "3":
                    System.out.println("executing CancelAll()...");
                    wrm.cancelAll();
                    break;

                case "4":
                    System.out.println("executing CanDoctorGoHome()...");
                    System.out.println(wrm.canDoctorGoHome());
                    break;

                case "5":
                    System.out.println("executing ShowAllPatient()...");
                    wrm.showAllPatient();
                    break;

                case "6":
                    System.out.println("executing ReverseTheLine()...");
                    wrm.reverseTheLine();
                    break;

                case "7":
                    System.out.println("\nThank You For Using \"Waiting Room Management System\"");
                    return;

                default:
                    System.out.println("No Such Option");
            }
            System.out.println();
        }
    }
}

// NO NEED THIS SUBMIT THIS CLASS
public class WRM {
    Patient dh;

    //The constructor is already created for you
    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient addp = new Patient(id, name, age, bloodgroup, null, null);

        Patient tail = dh.prev;

        tail.next = addp;
        addp.prev = tail;
        addp.next = dh;
        dh.prev = addp;
    }

    public void servePatient() {
        Patient queue = dh.next;

        if(dh.next == dh) {
            System.out.println("No patients in line");
        } else {
            dh.next = queue.next;
            queue.next.prev = dh;

            System.out.println("serving" + queue.id);
        }
    }

    public void showAllPatient() {
        Patient queue = dh.next;

        if(dh.next == dh) {
            System.out.println("no patients in line");
        } else {
            while(queue != dh) {
                System.out.println(queue.name);
                queue = queue.next;
            }
        }
    }

    public Boolean canDoctorGoHome() {
        if(dh.next == dh) {
            return true;
        }
        return false;
    }

    public void cancelAll() {
        dh.next = dh;
        dh.prev = dh;

        System.out.println("cancelled");
    }


   public void reverseTheLine() {
        Patient curr = dh;

        if(dh.next == dh) {
            System.out.println("no patients in line");
        } else {
            while(curr != dh) {
                Patient temp = curr.next;
                curr.next = curr.prev;
                curr.prev = temp;
                curr = temp;
            }

            System.out.println("reversed");
            showAllPatient();
        }
    }

}



