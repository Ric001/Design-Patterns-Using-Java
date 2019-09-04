import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Objects;

import java.util.logging.Logger;

import sun.launcher.resources.launcher;
import sun.util.logging.resources.logging;

public class MyClass {

    public static void main(String[] args) {
        new StringTests().appending();
        // final StringTests testOne = new StringTests();
        // final StringTests testTwo = new StringTests();
        // testOne.setVal("Natural");
        // testTwo.setVal("Natural");

        // if (testOne.match(testTwo))
        //     System.out.println("They do Match");

    }

}



// jdbc:oracle:thin:@//172.27.5.17:1521/PCDLOL

// -Doracle.net.tns_admin=C:\Users\jose osorio soto\Desktop\ff\tnsnames.ora

// oracle.jdbc.timezoneAsRegion=false

class Calc {
    // Return type is not part of the method signature
    double calcAverage(double marks1, int marks2) {
        return (marks1 + marks2) / 2.0;
    }

    double calcAverage(int marks1, double marks2) {
        return (marks1 + marks2) / 2.0;
    }

    /** This is an overloaded method */
    private int calcAverage(float mark1, int mark2) {
        return (mark1 + mark2) / 2;
    }

    public double calcAverage(int marks1, int marks2) {
        /** This is an overloaded method */
        return (marks1 + marks2) / 2.0;
    }

    /***
     * Constructors can be user-defined constructors if they were created by a coder
     * instead of the java compiler.
     */
}

class Employee {
    String name;
    int age;
    // Initializers blocks are used to initialize instance data
    // from anonymous classes
    {
        System.out.println("Im an initializer block");
    }

    {
        System.out.println("Im an initializer block II");
    }

    {
        System.out.println("Im an initializer block III");
    }

    /**
     * 
     */
    Employee() {
        // this();
        /***
         * Recursive constructor invocation, since the constructor is enternally being
         * callled by himself
         */
    }

    /**
     * Employee Constructor
     * 
     * @param newAge  - The Person Age
     * @param newName - The Person Name
     */
    Employee(int newAge, String newName) {
        name = newName;
        age = newAge;
        System.out.println("Constructor(int, String)");
    }

    public int daysOffWork(int... days) {
        int daysOff = 0;
        for (int i = 0; i < days.length; i++)
            daysOff += days[i];
        return daysOff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee [age=" + age + ", name=" + name + "]";
    }

    
}

class PersonOwn {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + "]";
    }
}


class Phone {
    private double weight;
    private String model;
    private String company;

    void makeCall() {
        System.out.println("Making call");
    }

    void recieveCall() {
        System.out.println("Recieving call");    
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    
}

class StringTests {
    
    private final static Logger LOG = Logger.getLogger(StringTests.class.getName());

    public void test() {
        LOG.info("[ENTERING test(): void]");
        String jhon = new String("Jhon");
        String Jhon = new String("Jhon");

        String Harry = "Harry";
        String harry = "Harry";
        if (Harry == harry)
            LOG.info("[HARRY == HARRY]");
        else
            LOG.info("[HARRY != Harry]");
        
        if (jhon == Jhon)
            LOG.info("[Jhon == Jhon]");
        else 
            LOG.info("[Jhon != Jhon]");
    }

    public void test2() {
        LOG.info("[ENTERING test2(): void]");

        final StringBuilder builder = new StringBuilder("Dark Necesseties");
        final StringBuffer buffer = new StringBuffer("TURURURURURURURUR");
        
        final String sBuilder = new String(builder);
        final String sBuffer = new String(buffer);
        
        System.out.println(sBuilder);
        System.out.println(sBuffer);
        char[] chain = new char[]{ 'c','h','a','i','n' };
        final String chainS = new String(chain);
        System.out.println(chainS);

        final String letters = "ABCD";
        final int NOT_EXISTS = -1;
        final char str = 'h';
        if (letters.indexOf(str) == NOT_EXISTS)
            System.out.println(letters.indexOf('D'));

        System.out.println(letters.indexOf('A'));
        System.out.println(letters.indexOf('C'));

        LOG.info("[ENDING test2(): void]");
    }

    public void test3() {
        
        final String name = "Paul";
        System.out.println(name.charAt(0));
        System.out.println(name.charAt(2));

        final String letters = "ABCAB";
        System.out.println(letters.indexOf("B",2));
    }

    public void substring() {
        final String exam = "Oracle";
        final String sub = exam.substring(2, 4);
        System.out.println(sub);
    }

    public void trim() {
        //Remove the leading and traling space of a string, but not the space within
        final String varWithSpace = " AB CB  ";
        System.out.print(":");
        System.out.print(varWithSpace);
        System.out.print(":");

        final String varWithoutSpace = varWithSpace.trim();
        System.out.print(":");
        System.out.print(varWithoutSpace);
        System.out.print(":");
    }

    public void replace() {
        final String letters = "ABCAB";
        System.out.println(letters.replace('B', 'b'));
        System.out.println(letters.replace("CA", "12"));
    }

    public void len() {
        final String letters = "ABCAB";
        System.out.println("Letters Len: " + letters.length());
    }

    public void starts() {
        final String letters = "ABCAB";
        System.out.println(letters.startsWith("A"));
        System.out.println(letters.startsWith("AB"));
        System.out.println(letters.startsWith("A", 3));
    }

    public void ends() {
        final String letters = "ABCAB";
        
        System.out.println(letters.endsWith("CAB"));
        System.out.println(letters.endsWith("B"));
        System.out.println(letters.endsWith("b"));
    }

    public void chaining() {
        
        final String result = "Sunday ".replace(' ', 'Z').trim().concat("M n");
        
        String day = "SunDday";
        
        day.replace('D', 'Z').substring(3);
        System.out.println(day);
        day = day.replace('D', 'Z').substring(3);
        System.out.println(day);
        System.out.println(result);
    
    }

    public void concatanating() {
        LOG.info("[ENTERING concatanating(): void]");

        final StringBuilder builder = new StringBuilder();
        builder.append("I pounder of something great\n")
            .append("My lungs will fill and then deflate\n")
            .append("They fill with fire, exhale desire\n")
            .append("I know its dire my time today\n");
        System.out.println(builder);
        
        final String letters = "OCJA" + "Cert" + "Exam";
        System.out.println(letters);
        LOG.info("[ENDING concatanating(): void]");
    }

    private int numReceived() {
        return 200;
    }
    
    private int inTransit() {
        return 300;
    }

    public void logToAFile() {
        final String loggingTxt = "Logging txt: " + (numReceived() + inTransit());
        System.out.println(loggingTxt);

        String lang = "Java";
        lang += " is everywhere!";
        String initializedToNull = null;
        initializedToNull += "Java";
        System.out.println(lang);
        System.out.println(initializedToNull);
    }

    private String val;
    
    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    public boolean match(Object o) {
        if (this == o || Objects.isNull(o) || !(o instanceof StringTests))
            return true;
        
        final StringTests test = (StringTests) o;
        final String testVal = test.getVal();
    
        if (Objects.isNull(testVal) || !testVal.equals(val))
            return false;
        
        return true;
    }

    public void compare() {
        LOG.info("[ENTERING compare(): void]");
        
        final String lang1 = "Java";
        final String lang2 = "JaScala";
        
        final String returnValue1 = lang1.substring(0, 1);
        final String returnValue2 = lang2.substring(0,1);

        System.out.println(returnValue1 == returnValue2);
        System.out.println(returnValue1.equals(returnValue2));
        
        LOG.info("[ENDING compare(): void]");
    }

    public void building() {
        final StringBuilder sb1 = new StringBuilder();
        final StringBuilder sb2 = new StringBuilder(sb1);
        final StringBuilder sb3 = new StringBuilder(50);
        final StringBuilder sb4 = new StringBuilder("Bhrama Gupta");
    }

    private StringBuilder builder;
    public boolean making(String line) {
        final String lineBreak = "\n";

        if (Objects.isNull(builder) && !line.isEmpty()) 
            builder = new StringBuilder(line.length());

        if (line.isEmpty())
            return false;
        
        builder.append(line + lineBreak);
    
        return true;
    }

    public void testing() {
        LOG.info("[ENTERING testing(): void]");

        making("Im never let u go, when i never did");
        if (builder.charAt(0) == 'I')
            System.out.println("Theres a coincidence");
    
        LOG.info("[ENDING testing(): void]");
    }

    public void appending() {
        LOG.info("[ENTERING append(): void]");

        //You can add data from multiple data types to a StringBuilder
        //Since this method is overloaded

        final StringBuilder letters = new StringBuilder();
        final PersonOwn person = new PersonOwn();
        person.setName("The Red Hot Chili peppers");
        letters.append("String")
                .append('c') // char
                .append(true) // boolean
                .append(new char[] {'c', 'd'}) // char array
                .apend(person) 
                .append(20)
                .append(29.5F)
                .append(new StringBuilder("Many Moons"));

        LOG.info("[ENDIND append(): void] -> " + letters);
    }
}