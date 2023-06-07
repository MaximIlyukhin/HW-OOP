import java.util.ArrayList;

public class FamilyTree {
    private ArrayList<Person> personList;
    public FamilyTree() {
        this(new ArrayList<>());
    }
    public FamilyTree(ArrayList<Person> personList) {
        this.personList = personList;
    }
    public boolean add(Person person){
        if (!personList.contains(person)){
            personList.add(person);
            if(person.getFather() != null){
                person.getFather().addChild(person);
            }
            if(person.getMother() != null){
                person.getMother().addChild(person);
            }
            return true;
        }
        return false;
    }
    public Person getByName(String name){
        for(Person person: personList){
            if (person.getName().equals(name)){
                return person;
            }
        }
        return null;
    }
    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("In tree ");
        sb.append(personList.size());
        sb.append(" objects:  \n");
        for(Person person: personList){
            sb.append(person.getInfo());
            sb.append("\n");
        }
        return sb.toString();
    }
}
