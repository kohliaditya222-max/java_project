import java.util.Scanner;

public class roomAllot_2 {

    static class Student {
        String name;
        String gender;

        Student(String name, String gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    static class Room {
        Student[] students = new Student[2];
        int count = 0;
        String gender = "";

        boolean canAllocate(Student s) {
            if (count == 0) {
                return true;
            }

            return count < 2 && gender.equals(s.gender);
        }

        void addStudents(Student s) {
            students[count] = s;
            count++;

            if (count == 1) {
                gender = s.gender;
            }
        }

        void displayRooms(int roomNo) {
            System.out.println("\nRoom " + roomNo + ":");

            if (count == 0) {
                System.out.println("Empty");
            } else {
                for (int i = 0; i < count; i++) {
                    System.out.println(
                        students[i].name + " (" +
                        students[i].gender + ")"
                    );
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student[] students = new Student[21];
        Room[] rooms = new Room[10];

        // Create 10 room objects
        for (int i = 0; i < 10; i++) {
            rooms[i] = new Room();
        }

        // Take students' details
        for (int i = 0; i < 21; i++) {
            System.out.println(
                "\nEnter details of student " + (i + 1)
            );

            System.out.print("Enter name: ");
            String name = sc.nextLine();

            String gender;

            while (true) {
                System.out.print(
                    "Enter gender (Male/Female): "
                );

                gender = sc.nextLine().trim();

                if (gender.equalsIgnoreCase("Male")) {
                    gender = "Male";
                    break;
                } else if (gender.equalsIgnoreCase("Female")) {
                    gender = "Female";
                    break;
                } else {
                    System.out.println(
                        "Enter Male or Female only!"
                    );
                }
            }

            students[i] = new Student(name, gender);
        }

        // Allocate rooms
        Student[] unallocated = new Student[21];
        int unallocatedCount = 0;

        for (int i = 0; i < 21; i++) {
            boolean allocated = false;

            for (int j = 0; j < 10; j++) {
                if (rooms[j].canAllocate(students[i])) {
                    rooms[j].addStudents(students[i]);
                    allocated = true;
                    break;
                }
            }

            if (!allocated) {
                unallocated[unallocatedCount] = students[i];
                unallocatedCount++;
            }
        }

        // Display room allocation
        System.out.println(
            "\n====== ROOM ALLOCATION ======"
        );

        for (int i = 0; i < 10; i++) {
            rooms[i].displayRooms(i + 1);
        }

        // Display students without rooms
        System.out.println(
            "\n====== STUDENTS WITHOUT ROOM ======"
        );

        if (unallocatedCount == 0) {
            System.out.println("All students got a room.");
        } else {
            for (int i = 0; i < unallocatedCount; i++) {
                System.out.println(
                    unallocated[i].name + " (" +
                    unallocated[i].gender + ")"
                );
            }
        }

        sc.close();
    }
}
