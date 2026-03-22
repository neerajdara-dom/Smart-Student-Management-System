import java.util.*;
import java.io.*;

class Students implements Serializable{
    int id;
    String name;
    String course;
    int marks;
    char grade;
}
public class SMS{
    private static final String FILE_NAME = "students.dat";

    public static void saveData(ArrayList<Students> studentsData){
        try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream("students.dat"))){
            oos.writeObject(studentsData);
            System.out.println("Data Saved successfully");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static ArrayList<Students> loadData(){
        ArrayList<Students> studentsData=new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            studentsData = (ArrayList<Students>) ois.readObject();
            System.out.println("Data loaded successfully!");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found, starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return studentsData;
    }
    public static void main(String[] args) {
        ArrayList<Students> studentsData = loadData();
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("1. Add Students");
            System.out.println("2. View Students");
            System.out.println("3. Search Students");
            System.out.println("4. Update Students");
            System.out.println("5. Delete Students");
            System.out.println("6. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if(choice==1){
                System.out.println("# of students : ");
                int noOfStudents=sc.nextInt();
                sc.nextLine();
                for(int i=0;i<noOfStudents;i++){
                    Students obj=new Students();
                    System.out.println("Enter the id : ");
                    obj.id=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter the name : ");
                    obj.name=sc.nextLine();
                    System.out.println("Enter the course : ");
                    obj.course=sc.nextLine();
                    System.out.println("Enter the marks /100 : ");
                    obj.marks=sc.nextInt();
                    if(obj.marks>=91&&obj.marks<=100){
                        obj.grade='A';
                    }else if(obj.marks>=81&&obj.marks<=90){
                        obj.grade='B';
                    }else if(obj.marks>=71&&obj.marks<=80){
                        obj.grade='C';
                    }else if(obj.marks>=61&&obj.marks<=70){
                        obj.grade='D';
                    }else if(obj.marks>=51&&obj.marks<=60){
                        obj.grade='E';
                    }else{
                        obj.grade='F';
                    }
                    sc.nextLine();
                    studentsData.add(obj);
                }
            }
            else if(choice==2){
                for(Students s:studentsData){
                    System.out.println(s.id+" "+s.name+" "+s.course+" "+s.marks);
                }
                System.out.println("Ranking System");
                System.out.println("---------------");
                for(Students p:studentsData){
                    if(p.grade=='A'){
                        System.out.println("1st Rank -> "+p.name+" "+p.id);
                    }
                    else if(p.grade=='B'){
                        System.out.println("2nd Rank -> "+p.name+" "+p.id);
                    }
                    else if(p.grade=='C'){
                        System.out.println("3rd Rank -> "+p.name+" "+p.id);
                    }else{
                        System.out.println("No Rank -> "+p.name+" "+p.id);
                    }
                }


            }
            else if(choice==3){
                System.out.println("Enter the id : ");
                int searchId=sc.nextInt();
                sc.nextLine();
                for(Students s:studentsData){
                    if(s.id==searchId){
                        System.out.println(s.id+" "+s.name+" "+s.course+" "+s.marks);
                    }
                    else{
                        System.out.println("Students data not stored !");
                    }
                }

            }
            else if(choice==4){
                System.out.println("Enter the id to update : ");
                int updateId=sc.nextInt();
                sc.nextLine();
                for(Students s:studentsData){
                    if(s.id==updateId){
                        System.out.println("Enter the new name : ");
                        s.name=sc.nextLine();
                    }
                }
            }
            else if(choice==5){
                System.out.println("Enter the id to be deleted : ");
                int deleteId=sc.nextInt();
                sc.nextLine();
                for(int i=0;i<studentsData.size();i++){
                    if(studentsData.get(i).id==deleteId){
                        studentsData.remove(i);
                        System.out.println("Deleted !");
                    }

                }
            }
            else if(choice==6){
                saveData(studentsData);
                break;
            }
            else{
                System.out.println("Option is not Listed !");
            }


        }
    }
}