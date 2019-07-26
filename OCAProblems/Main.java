public class Main {

    static int counter = 23 / 2;
    static long nombre = Long.MAX_VALUE;
    static float floatNombre = nombre;
    static long name2 = (long) floatNombre;

    public Main(String param) {
        System.out.println(param);
    }
    public Main() {}

    /*
     * public static void main(String[] args) { System.out.println(nombre);
     * System.out.println(floatNombre); //main(args); }
     */

    /*public static void main(String[] args) {
        // System.out.println(nombre);
        // System.out.println(floatNombre);
        // main(args);

        /*
         * System.out.println("\n"+ nombre + "\n" + floatNombre + "\n" + name2); String
         * bin = Integer.toBinaryString(200); int decimal = Integer.parseInt(/*bin
         * "12"); System.out.println(decimal); System.out.println(bin); float average =
         * 10002.449F; // Default decimal treatment is Double. Use F to tell the
         * compiler that this hava to be treated as a /**floating point value double
         * dAverage = 120.1762D; // Default double treatment is Double D is redundant
         *
        // Hascode test
        Product product = new Product("JABON", "200", 1);
        Product product2 = new Product("HP", "200",1 );

        System.out.println("ARE THE SAME? : " + product.equals(product2));
        System.out.println("HASCODE1: " + product.hashCode() + "\n HASCODE2: " + product2.hashCode());
        new Main().testEnums();

    }*/

    public static void main(String[] args) {
        char c2 = 122;
        char c3 = '\u0122';
        //enforcing negative char value
        char c4 = (char) -122;
        System.out.println(c2 + "\n" + c3 + "\n" + c4);
    }

    protected static void main(String[] args, String another) {
        System.out.println(args[0]);
    }

    private void testEnums() {
        Songs song1 = Songs.MALDITO_DUENDE;
        System.out.println("Song name: " + song1);
        
        for (Songs song : Songs.values())
            System.out.println("Name: " + song.name() + "\n" + "Index: " + song.ordinal());
        
        Songs songFromString = Songs.valueOf("OPIO");
        System.out.println(songFromString);

        switch(song1) {
            case MALDITO_DUENDE:
                Songs.MALDITO_DUENDE.printSelected();
                break;
            case DESHACER_EL_MUNDO:
                Songs.DESHACER_EL_MUNDO.printSelected();
                break;
            case OPIO:
                Songs.OPIO.printSelected();
                break;
            case HECHIZO:
                Songs.HECHIZO.printSelected();
            default:
                System.out.println("UNSUPPORTED SONG TYPE");
        }

        OnlyOnce one = OnlyOnce.ONCE;
        OnlyOnce two = OnlyOnce.ONCE;

        final Season WINTER = Season.WINTER;
        WINTER.printHours();
        final ForbiddenConjuries conjury = ForbiddenConjuries.IMPERIO;
        final ForbiddenConjuries conjury2 = ForbiddenConjuries.CRUCIATUS;
        conjury.printConjury();
        conjury2.printConjury();
    }

}

class Product {
    
    private String name;
    private String price;
    private int id;

    public Product(String name, String price, int id) {
        this.name = name;
        this.price = price;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Product))
            return false;
        
        Product incomingProduct = (Product) object;
        if (incomingProduct.getName().equals(name) && incomingProduct.getPrice().equals(price))
            if (incomingProduct.getId() == id)
                return true;

        return false;
    }

    @Override
    public int hashCode() {
        return id * 7 * name.hashCode();
    }
}

enum Songs {
    MALDITO_DUENDE("Maldito Duende"), HECHIZO("Hechizo"), DESHACER_EL_MUNDO("Deshacher el Mundo"), OPIO("Opio");
    private String song;
    private Songs(String song) {
        this.song = song;
    }

    public void printSelected() {
        System.out.println("Song: " + song);
    }
}

enum OnlyOnce {
    ONCE(true);
    private OnlyOne(boolean onlyOne) {
        System.out.println(onlyOne);
    }
}

enum Season {
    WINTER { @Override public void printHours() { System.out.println("(WINTER)9AM - 5PM");} },
    SUMMER { @Override public void printHours() { System.out.println("9AM - 4pm");} },
    SPRING { @Overide public void printHours() { System.out.println("10AM - 12AM");} },
    FALL { @Override public void printHours() { System.out.println("8AM - 9PM");} };   

    public abstract void printHours();
}

enum ForbiddenConjuries {
    IMPERIO {
        @Override public void printConjury() { System.out.println("IMPERIO"); }
    }, 
    CRUCIATUS {
        public void printConjury() { System.out.println("CRUCIATUS"); }
    };
}