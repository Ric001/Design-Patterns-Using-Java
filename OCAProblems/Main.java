public class Main {

        static int counter = 23/2;
        static long nombre = Long.MAX_VALUE;
        static float floatNombre = nombre;

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
	    new Main();	
        }
        protected static void main(String[] args, String another) {
            System.out.println(args[0]);
        }



    }