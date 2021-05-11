public class StrategyPatternExample {

    public static void main(String[] args) {
        Human yongHa = new YongHa();
        yongHa.setMove(new Run());
        yongHa.fly();
        yongHa.move();
        yongHa.acrobatic();

        yongHa.setAcrobatic(new BackHandSpring());
        yongHa.acrobatic();

        yongHa.setFly(new SkyDiving());
        yongHa.fly();


        yongHa.setFly(new Bungee());
        yongHa.fly();

        yongHa.setAcrobatic(new ForwardSpring());
        yongHa.acrobatic();
    }
}

class YongHa extends Human {

    public YongHa() {
        super(new AirPlane(), new Walk(), new Cannot());
    }
}

abstract class Human {
    private Fly fly;
    private Move move;
    private Acrobatic acrobatic;

    public Human(Fly fly, Move move, Acrobatic acrobatic) {
        this.fly = fly;
        this.move = move;
        this.acrobatic = acrobatic;
    }

    public void setFly(Fly fly) {
        this.fly = fly;
    }

    public void setMove(Move move) {
        this.move = move;
    }

    public void setAcrobatic(Acrobatic acrobatic) {
        this.acrobatic = acrobatic;
    }

    public void fly() {
        fly.fly();
    }

    public void move() {
        move.move();
    }

    public void acrobatic() {
        acrobatic.acrobatic();
    }
}

interface Fly {
    void fly();
}

class AirPlane implements Fly{

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Bungee implements Fly{

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class SkyDiving implements Fly{

    @Override
    public void fly() {
        System.out.println(this.getClass().getSimpleName());
    }
}

interface Move {
    void move();
}

class Run implements Move {

    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class Walk implements Move {

    @Override
    public void move() {
        System.out.println(this.getClass().getSimpleName());
    }
}

interface Acrobatic {
    void acrobatic();
}


class Cannot implements Acrobatic {

    @Override
    public void acrobatic() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class ForwardSpring implements Acrobatic {

    @Override
    public void acrobatic() {
        System.out.println(this.getClass().getSimpleName());
    }
}

class BackHandSpring implements Acrobatic {

    @Override
    public void acrobatic() {
        System.out.println(this.getClass().getSimpleName());
    }
}