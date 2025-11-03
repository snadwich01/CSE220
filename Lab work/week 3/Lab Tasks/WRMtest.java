public class WRM {

    Patient dh; // dummy head

    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    // Add new patient to the end of list
    public void registerPatient(int id, String name, int age, String bloodgroup) {
        Patient newPatient = new Patient(id, name, age, bloodgroup, null, null);

        // connect to last
        Patient last = dh.prev;

        last.next = newPatient;
        newPatient.prev = last;

        newPatient.next = dh;
        dh.prev = newPatient;
    }

    // Serve first patient (front of line)
    public void servePatient() {
        if (dh.next == dh) {
            System.out.println("No patient to serve.");
            return;
        }

        Patient first = dh.next;

        dh.next = first.next;
        first.next.prev = dh;

        System.out.println("Served patient ID: " + first.id);
    }

    // Show all patients from first to last
    public void showAllPatient() {
        if (dh.next == dh) {
            System.out.println("No patients in line.");
            return;
        }

        Patient temp = dh.next;
        System.out.print("Current line: ");
        while (temp != dh) {
            System.out.print(temp.id + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    // Check if list is empty
    public Boolean canDoctorGoHome() {
        return (dh.next == dh);
    }

    // Remove all patients
    public void cancelAll() {
        dh.next = dh;
        dh.prev = dh;
        System.out.println("All appointments cancelled.");
    }

    // Reverse the patient order
    public void reverseTheLine() {
        if (dh.next == dh || dh.next.next == dh) return; // no need if empty or 1 patient

        Patient curr = dh;
        do {
            Patient temp = curr.next;
            curr.next = curr.prev;
            curr.prev = temp;
            curr = temp;
        } while (curr != dh);

        System.out.println("Patient line reversed.");
    }
}