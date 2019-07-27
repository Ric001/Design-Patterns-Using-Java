public class AnonInner {

    @FunctionalInterface
    public interface SaleTodayOnly {
        public int dollarsOff();
    }

    public int pay() {
        return addmission(5, () -> { return 200; });
    }

    public int payAnnon() {
        return addmission(10, new SaleTodayOnly() {
            @Override
            public int dollarsOff() {
                return 300;
            }
        });
    }

    private int addmission(int basePrice, SaleTodayOnly todayOnly) {
        return todayOnly.dollarsOff() - basePrice;
    }

    public static void main(String[] args) {
        System.out.println(new AnonInner().pay());

        System.out.println(new AnonInner().payAnnon());
    }
}