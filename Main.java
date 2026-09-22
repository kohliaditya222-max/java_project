import java.util.Scanner;

public class Main {

    static void dataEntry(String[] students){
        Scanner sc = new Scanner(System.in);

        for(int i=0; i<students.length; i++){
            System.out.println("Enter student "+(i+1)+" name:");
            students[i] = sc.nextLine();
        }
    }

    static void roomAllotment(String[] students , String[][] rooms){
        int studentIndex = 0;

        for(int i=0; i<rooms.length;i++){
            for(int j=0; j<rooms[i].length; j++){
                if(studentIndex < students.length){
                    rooms[i][j] = students[studentIndex];
                    studentIndex++;
                }
            }
        }
        if(studentIndex < students.length){
            System.out.println("\nStudents without rooms : "+ students[studentIndex]);
        }
    }
    public static void main(String[] args) {
        String[] students = new String[21];
        String[][] rooms = new String[10][2];

        dataEntry(students);
        roomAllotment(students, rooms);

        System.out.println("\nRoom Allotment : ");

        for(int i=0; i<rooms.length; i++){
            System.out.println("Room "+ (i+1)+": "+rooms[i][0]+ " & "+ rooms[i][1]);
        }
    }
}
