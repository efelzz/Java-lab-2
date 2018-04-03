public class Main {
    public static void main(String args []){
        Automata nescafe = new Automata();
        System.out.println(nescafe.on());
        System.out.println(nescafe.coin(10));
        System.out.println(nescafe.cancel());
        System.out.println(nescafe.coin(100));
        nescafe.getMenu();
        System.out.println(nescafe.choice(3));
        System.out.println(nescafe.off());
        return;
    }
}
