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
            while(queue.next != dh) {
                System.out.println(queue.id);
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
        Patient curr = dh.next;
        Patient queue = curr.next;

        if(dh.next == dh) {
            System.out.println("no patients in line");
        } else {
            while (queue.next != dh) {
                curr.next = curr.prev;
                curr.prev = queue;
                curr = queue;
            }
            System.out.println("reversed");
        }
    }

}
