import java.util.*;

class Students{
    int id;
    String name;
    String course;
}
public class SMS{
    public static void main(String[] args) {
        ArrayList<Students> studentsData = new ArrayList<>();
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
                    studentsData.add(obj);
                }
            }
            else if(choice==2){
                for(Students s:studentsData){
                    System.out.println(s.id+" "+s.name+" "+s.course);
                }
            }
            else if(choice==3){
                System.out.println("Enter the id : ");
                int searchId=sc.nextInt();
                sc.nextLine();
                for(Students s:studentsData){
                    if(s.id==searchId){
                        System.out.println(s.id+" "+s.name+" "+s.course);
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
                break;
            }
            else{
                System.out.println("Option is not Listed !");
            }


        }
    }
}