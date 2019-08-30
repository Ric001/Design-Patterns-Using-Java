import java.util.logging.Logger;

class PersonIII {
    public String name;
    public int height;

}

public class Test {
    private static final Logger LOG = Logger.getLogger(Test.class.getName());

    public static void swap(PersonI p1, PersonI p2) {
        LOG.info("[ENTERING swap(PersonI p1, PersonI p2)]");
        PersonI tmp = p1;
        p1 = p2;
        p2 = tmp;
        System.out.println(p1.getName() + ":" + p2.getName());
    }

    private static void resetValueOfMemberVariable(PersonI p1) {
        LOG.info("[ENTERING  static void resetValueOfMemberVariable(PersonI p1)]");
        p1.setName("TOBY TOBY");
    }
    /*
    private static void someMethod(PersonIII person) {
        person.name = "someMethod";
        System.out.println(person.name);
    }

    private static void anotherMethod(PersonIII person) {
        person = new PersonIII();
        person.name = "anotherMethod";
        System.out.println(person.name);
    }*/

    private static void someMethod(int val) {
        ++val;
        System.out.println(val);
    } 

    private static void anotherMethod(int val) {
        val = 20;
        System.out.println(val);
    }

    public static void main(String[] args) {
        int ejb = 10;
        anotherMethod(ejb);
        System.out.println(ejb);
        someMethod(ejb);
        System.out.println(ejb);
        /**
         * 20
         * 10
         * 11
         * 10
         */
    }
}


class PersonI {

    private String name;

    private final static Logger LOG = Logger.getLogger(PersonI.class.getName());
    PersonI(String name) {
        LOG.info("[CREATING TDD Person(String name)]");
        this.name = name;
    }

    public String getName() {
        LOG.info("[ENTERING getName(): String]");
        return name;
    }

    public void setName(String name) {
        LOG.info("[ENTERING setName(String name): void]");
        this.name = name;
    }

    public int getInt() {
        final byte number = 8;
        return number;
    }
}




