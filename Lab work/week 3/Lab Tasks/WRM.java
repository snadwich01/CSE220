public class WRM {
    Patient dh; // dummy head

    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh; // circular link
        dh.prev = dh;
    }

    // Register a patient (add to the end of the line)
    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient newP = new Patient(id, name, age, bloodgroup, null, null);

        // Insert before dummy head (end of list)
        newP.prev = dh.prev;
        newP.next = dh;

        dh.prev.next = newP;
        dh.prev = newP;

        System.out.println("Patient " + id + " registered.");
    }

    // Serve the first patient (remove from the start)
    public void servePatient() {
        if (dh.next == dh) {
            System.out.println("No patients to serve!");
            return;
        }

        Patient first = dh.next;

        dh.next = first.next;
        first.next.prev = dh;

        System.out.println("Serving patient: " + first.id);
    }

    // Show all patients in order
    public void showAllPatient() {
        if (dh.next == dh) {
            System.out.println("No patients waiting.");
            return;
        }

        System.out.print("Patients in line: ");
        Patient temp = dh.next;
        while (temp != dh) {
            System.out.print(temp.id + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Check if doctor can go home
    public Boolean canDoctorGoHome() {
        return dh.next == dh; // true if empty
    }

    // Cancel all appointments
    public void cancelAll() {
        dh.next = dh;
        dh.prev = dh;
        System.out.println("All appointments cancelled.");
    }

    // Reverse the line
    public void reverseTheLine() {
        if (dh.next == dh || dh.next.next == dh) return; // 0 or 1 patient

        Patient current = dh;
        do {
            Patient temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        } while (current != dh);

        System.out.println("Line reversed.");
    }
}
