package Lavel2.lesson01.home;

public class Human {

    private String type;
    private String name;
    private float limitRun;
    private float limitJump;

    public Human(String type, String name, float limitRun, float limitJump) {
        this.type = type;
        this.name = name;
        this.limitRun = limitRun;
        this.limitJump = limitJump;
    }

    void run(float limitRun){
        System.out.println("Запас на бег у человека "+this.name+": " +this.limitRun);
        System.out.println("Человек пробежал на "+limitRun);
    }

    void jump(float limitJump){
        System.out.println("Запас прыжка у человека "+this.name+": "+this.limitJump);
        System.out.println("Человек прыгнул на "+limitJump);
    }

    public void setLimitJump(float limitJump) {
        this.limitJump -= limitJump;
        System.out.println("Остаток для прыжка у человека "+this.name+": "+this.limitJump);
    }

    public void setLimitRun(float limitRun) {
        this.limitRun -= limitRun;
        System.out.println("Остаток для бега у человека "+this.name+": "+this.limitRun);
    }

    protected boolean checkRun(float limitRun){
        return (this.limitRun - limitRun >= 0);
    }

    protected boolean checkJump(float limitJump){
        return (this.limitJump - limitJump >= 0);
    }
}