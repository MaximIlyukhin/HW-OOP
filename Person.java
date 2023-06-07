import java.time.LocalDate;
import java.util.ArrayList;

public class Person {
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Person father;
    private Person mother;
    private ArrayList<Person> children;
    public Person(String name, Gender gender, LocalDate of){ this (name, gender, null, null);}
    public Person(String name, Gender gender, LocalDate birthDate, Person father, Person mother){
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Person(String name, Gender gender, Person father, Person mother){
        this(name, gender, null, father, mother);
    }
    public boolean addChild(Person child){
        if(!children.contains(child)){
            children.add(child);
            return true;
        }
        return false;
    }

    public String getName(){
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public LocalDate getDeathDate() {
        return deathDate;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public ArrayList<Person> getChildren() {
        return children;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("name: ");
        sb.append(name);
        sb.append(", ");
        sb.append(getMotherInfo());
        sb.append(", ");
        sb.append(getFatherInfo());
        sb.append(", ");
        sb.append(getChildrenInfo());
        return sb.toString();
    }

    private String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("chidren: ");
        if (children.size() != 0) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        } else {
            res.append("absent");
        }
        return res.toString();
    }


    private String getFatherInfo() {
        String res = "father: ";
        if (father != null){
            res+= father.getName();
        }else{res +="unknown";
        }
        return res;
    }

    private String getMotherInfo() {
        String res = "mother: ";
        if (mother != null) {
            res += mother.getName();
        } else {
            res += "unknown";
        }
        return res;
    }
        @Override
        public boolean equals(Object obj){
            if(this == obj){
                return true;
            }
            if (!(obj instanceof Person)){
                return false;
            }
            Person person = (Person) obj;
            return person.getName().equals(getName());
        }
}