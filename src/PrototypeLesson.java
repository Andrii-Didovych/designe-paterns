public class PrototypeLesson {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student student = new Student("John", 18);
        Student student1 = student.clone();
        System.out.println(student.getAge()+" "+student.getName());
        student1.setAge(23);
        System.out.println(student1.getAge()+" "+student1.getName());
    }
}

class Student implements Cloneable{

    private String name;
    private Integer age;

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    protected Student clone() throws CloneNotSupportedException {
        return (Student) super.clone();
    }
}


