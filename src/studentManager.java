import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class studentManager {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        while (true) {
            System.out.println("********************");
            System.out.println("*      1 插入      *");
            System.out.println("*      2 查找      *");
            System.out.println("*      3 删除      *");
            System.out.println("*      4 修改      *");
            System.out.println("*      5 输出      *");
            System.out.println("*      6 退出      *");
            System.out.println("********************");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);
            String number = sc.nextLine();
            switch (number){
                case "1":
                    addStudent(students);
                    break;
                case "2":
                    System.out.println("请输入你要查找学生的姓名：");
                    String searchName=sc.nextLine();
                    searchStudent(students,searchName);
                    break;
                case "3":
                    System.out.println("请输入你要删除学生的姓名：");
                    String deleName=sc.nextLine();
                    deleStudent(students,deleName);
                    break;
                case "4":
                    System.out.println("请输入你要修改学生的姓名：");
                    String updateName=sc.nextLine();
                    updateStudent(students,updateName);
                    break;
                case"5":
                    outputStudent(students);
                    break;
                case "6":
                    System.out.println("谢谢使用！");
                    System.exit(0);
            }

        }
    }


    //List students= new ArrayList();
    static void addStudent(ArrayList<Student> students){
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入学生学号：" );
        int id = Integer.parseInt(sc.nextLine());
        System.out.println("请输入学生姓名：");
        String name = sc.nextLine();
        System.out.println("请输入学生出生日期：");
        String birDate = sc.nextLine();
        System.out.println("请输入学生性别（男：fasle；女：true）：");
        boolean gender =Boolean.parseBoolean(sc.nextLine()) ;
        Student s = new Student();
        s.setId(id);
        s.setName(name);
        s.setBirDate(birDate);
        s.setGender(gender);
        //int low=0,high=students.size();
        int i=0;
        if(i<students.size()){
            if(id>students.get(i).getId()){
                i++;
        }else{
                //System.out.print(222);
                students.add(i,s);
            }
        }
        if(i>=students.size()){
            //System.out.print(111);
            students.add(s);
    }
        //students.add(s);
        System.out.println("添加学生成功!");
    }
    static void searchStudent(ArrayList<Student> students,String name){
        int i=-1;
        for(int j=0;j<students.size();j++){
            if(students.get(j).getName().equals(name)){
                i=j;
            }
            if(i==-1){
                System.out.println("该学生不存在!");
            }else if(i!=-1&&students.get(i).getGender()==false){
                    System.out.println(students.get(i).getId()+"  "+
                            students.get(i).getName()+"  "+
                            students.get(i).getBirDate()+"  "+
                            "男");
            }else if(i!=-1&&students.get(i).getGender()==true){
                    System.out.println(students.get(i).getId()+"  "+
                            students.get(i).getName()+"  "+
                            students.get(i).getBirDate()+"  "+
                            "女");
            }

        }

    }
    static void deleStudent(ArrayList<Student> students,String name){
        int j=-1;
        for(int i=0;i<students.size();i++){
            if(students.get(i).getName().equals(name)){
                j=i;
            }
        }
        if (j==-1){
            System.out.println("该学生不存在!");
        }else{
            students.remove(j);
            System.out.println("删除成功!");

        }
    }
    static void outputStudent(ArrayList<Student> students){
        if(students.size()==0)System.out.println("无信息");
        for(int i=0;i<students.size();i++){
            if(students.get(i).getGender()==false){
                System.out.println(students.get(i).getId()+"  "+
                        students.get(i).getName()+"  "+
                        students.get(i).getBirDate()+"  "+
                        "男");
            }
            if(students.get(i).getGender()==true){
                System.out.println(students.get(i).getId()+"  "+
                        students.get(i).getName()+"  "+
                        students.get(i).getBirDate()+"  "+
                        "女");
            }

        }

    }
    static void updateStudent(ArrayList<Student> students,String name) {
        boolean flag=false;
        boolean gender=false;
        String birDate = null;
        int id=0;
        while (!flag){
            for (int i = 0; i < students.size(); i++) {
                Student student = students.get(i);
                if (student.getName().equals(name)) {
                    flag=true;
                    birDate = student.getBirDate();
                    gender = student.getGender();
                    id=student.getId();
                    break;
                }
            }
        }
        if(flag){
            System.out.println("1修改学生的多组信息");
            System.out.println("2仅修改学生的出生日期");
            System.out.println("3仅修改学生的性别");
            System.out.println("4返回主菜单");
            System.out.println("请输入你的选择：");
            Scanner sc=new Scanner(System.in);
            String number2 = sc.nextLine();
            switch (number2) {
                case "1":
                    System.out.println("请输入学生新出生日期：");
                    birDate = sc.nextLine();
                    System.out.println("请输入学生新性别：");
                    gender =Boolean.parseBoolean( sc.nextLine());
                    break;
                case "2":
                    System.out.println("请输入学生新出生日期：");
                    birDate = sc.nextLine();
                    break;
                case "3":
                    System.out.println("请输入学生新性别：");
                    gender =Boolean.parseBoolean( sc.nextLine());
                    break;
                case "4":
                    return;
            }
            Student s=new Student();
            s.setId(id);
            s.setName(name);
            s.setBirDate(birDate);
            s.setGender(gender);
            for(int i=0;i<students.size();i++){
                if(students.get(i).getName().equals(name)){
                    students.set(i,s);
                }
                System.out.println("修改学生成功");
                break;
            }
        }else{
            System.out.println("该信息不存在，请重新输入!");
        }

    }




}
class Student{
    private int id;
    private String name;
    private String birDate;
    private boolean gender;
    Student() {
    }
    Student(int id, String name, String birDate, boolean gender) {
        this.id = id;
        this.name = name;
        this.birDate = birDate;
        this.gender = gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBirDate(String birDate) {
        this.birDate = birDate;
    }

    public String getBirDate() {
        return birDate;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    public boolean getGender() {
        return gender;
    }
}
