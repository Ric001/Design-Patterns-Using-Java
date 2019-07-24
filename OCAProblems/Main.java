public class Main {

        static int counter = 23/2;
        static long nombre = Long.MAX_VALUE;
        static float floatNombre = nombre;
        static long name2 = (long) floatNombre;
        
        public Main(String param) {
		System.out.println(param);
	}
 
        /*public static void main(String[] args) {
            System.out.println(nombre);
            System.out.println(floatNombre);
            //main(args);
        }*/

	public static void main(String[] args) {
            //System.out.println(nombre);
            //System.out.println(floatNombre);
            //main(args);
            System.out.println("\n"+ nombre + "\n" + floatNombre  + "\n" + name2);
            String bin = Integer.toBinaryString(200);
            int decimal = Integer.parseInt(/*bin**/ "12");
            System.out.println(decimal);

            float average = 10002.449F; // Default decimal treatment is Double. Use F to tell the compiler that this hava to be treated as a 
            /**floating point value  */
            double dAverage = 120.1762D; // Default double treatment is Double D is redundant
        }
        protected static void main(String[] args, String another) {
            System.out.println(args[0]);
        }



    }