public class Main {
    public static void main(String[] args) {
        Laberinto lab = new Laberinto(7,7);
        lab.setInicio(5,0);
        lab.setFinal(5,6);
        lab.setCamino(1,1);
        lab.setCamino(1,4);
        lab.setCamino(2,1);
        lab.setCamino(2,2);
        lab.setCamino(2,3);
        lab.setCamino(2,4);
        lab.setCamino(3,3);
        lab.setCamino(4,1);
        lab.setCamino(4,3);
        lab.setCamino(4,5);
        lab.setCamino(5,1);
        lab.setCamino(5,2);
        lab.setCamino(5,3);
        lab.setCamino(5,4);
        lab.setCamino(5,5);
        lab.resolver();
    }
}