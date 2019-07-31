public class App {
    private String greeting = "Hello";
    
    protected class Inner {
        public void go() {
            for (int i = 0; i < 8; i++)
                System.out.println( i + ") " + greeting + "\n");
        }
    }

    public void exec() {
        new Inner().go();
    }

    protected class A {
        private int x = 10;
        protected class B {
            private int x = 20;
            protected class C {
                private int x = 30;
                
                public void allXs() {
                    System.out.println(x);
                    System.out.println(this.x);
                    System.out.println(B.this.x);
                    System.out.println(A.this.x);
                }

            }
        }
    }

    private interface Secret {
        public void shh();
    }

    protected class DontTell implements Secret {
        @Override
        public void shh() {
            System.out.println("Como un efecto residual... Yo siempre tomare el desvio");
        }
    }

    private int len = 20;
    public void calculate() {
        final int width = 30;
        //Local Inner classes
        class Inner {
            public void calculate() {
                System.out.println(len * width);
            }
        }

        new Inner().calculate();
    }

    public void effectivelyFinal() {
        int four = 4;
        class Inner {}
        four = 5;
    }

    public abstract class SalaryCalc {
         abstract int calculate();
    }

    public int calc() {
        SalaryCalc salary = new SalaryCalc() {
            @Override
            public int calculate() {
               return  200;
            }
        };
        return 300 - salary.calculate();
    }


    interface Surprise {
        public void suprise();
    }

    public void hdbSurprise() {
        new Surprise() {
            @Override
            public void surprise() {
                System.out.println("HBD DUDE!!!");
            }
        }.suprise();
    }
    public static void main(String[] args) {
        /*new App().exec();
        new App().new Inner();
    
        new App().new A().new B().new C().allXs();
        
        new App().new DontTell().shh();
    
        new App().calculate();*/

        System.out.println(new App().calc());
        new App().hdbSurprise();
    }

}