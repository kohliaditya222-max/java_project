public class RoomAllotment{
        static String[][] students;
        static String[][] rooms;

        static void dataEntry(){
            students = new String[][]{
                {"Aditya", "Male"},
                {"Priya", "Female"},
                {"Rahul", "Male"},
                {"Neha" , "Female"},
                {"Aman", "Male"},
                {"Rohit", "Male"},
                {"Riya", "Female"},
                {"kartikey","Male"},
                {"karan","Male"},
                {"sneha", "Female"},
                {"Naina", "Female"},
                {"Kavya", "Female"},
                {"Sahil", "Male"},
                {"Vikas", "Male"},
                {"Anjali", "Female"},
                {"Arjun", "Male"},
                {"Divya", "Female"},
                {"Manav", "Male"},
                {"Aisha", "Female"},
                {"Simran", "Female"},
                {"Isha", "Female"},
            };
        }
        static void roomAllotment(){
            rooms = new String[10][2];
            boolean[] allocated = new boolean[students.length];
            int room = 0;

            for(int i=0; i<students.length && room < 10; i++){
                if(allocated[i]){
                    continue;
                }
                for(int j=i+1; j<students.length; j++){
                    if(!allocated[j] && students[i][1].equals(students[j][1])){
                        rooms[room][0] = students[i][0];
                        rooms[room][1] = students[j][0];

                        allocated[i] = true;
                        allocated[j] = true;

                        room++;
                        break;
                    }
                }
            }
            System.out.println("\n-----ROOM ALLOCATION------");
            for(int i=0; i<10; i++){
                if(rooms[i][0] != null){
                    System.out.println("Room" + (i+1) + " : "+ rooms[i][0] + " and " + rooms[i][1]);
                }
            }
            System.out.println("\n----UNALLOCATED STUDENTS----");
            for(int i=0; i<students.length; i++){
                if(!allocated[i]){
                System.out.println(students[i][0]);
            }
        }
    }
    public static void main(String[] args){
        dataEntry();
        roomAllotment();
    }
}
