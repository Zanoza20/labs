import java.util.Calendar;

class EquationCalculator {
    private double a;
    private double b;
    private double x;

    public EquationCalculator(double a,double b, double x) {
        this.a = a;
        this.b = b;
        this.x = x;
    }

    public double calculateY() {
        double y = Math.pow(Math.sin(Math.pow(x, 2) + a), 3) - Math.sqrt(x/b);
        return y;
    }
    public double calculateZ() {
        double z = (Math.pow(x, 3) / a) + Math.pow(Math.cos(x + b),3);
        return z;
    }

    public void printCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
        int month = calendar.get(Calendar.MONTH) + 1;

        System.out.println("День тижня : " + dayOfWeek);
        System.out.println("День місяця : " + dayOfMonth);
        System.out.println("Місяць : " + month);
    }

    public static void main(String[] args) {
        double a = 1.1;
        double b = 0.004;
        double x = 0.2;

        EquationCalculator calculator =new EquationCalculator(a, b, x);

        double y = calculator.calculateY();
        double z = calculator.calculateZ();

        System.out.println(" Y : " + y);
        System.out.println(" Z : " + z);

        calculator.printCurrentDate();

    }
}