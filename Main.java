import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();
        tree.add(new Person("Victor", Gender.Male, LocalDate.of(1970,1,1)));
        tree.add(new Person("Lena", Gender.Female, LocalDate.of(1975,10,20)));
        tree.add(new Person("Alex",Gender.Male, LocalDate.of(2000,1,10), tree.getByName("Victor"),tree.getByName("Lena")));
        tree.add(new Person("Via",Gender.Female, LocalDate.of(2010,10,1), tree.getByName("Victor"),tree.getByName("Lena")));
        System.out.println(tree.getInfo());
    }
}
