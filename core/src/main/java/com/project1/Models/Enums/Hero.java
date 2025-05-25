package com.project1.Models.Enums;

public enum Hero {

    SHANA("Shana", 4, 4, "assets/avatar/shana.png"),
    DIAMOND("Diamond", 7, 1, "assets/avatar/diamond.png"),
    SCARLET("Scarlet", 3, 5, "assets/avatar/scarlet.png"),
    LILITH("Lilith", 5, 3, "assets/avatar/lilith.png"),
    DASHER("Dasher", 2, 10, "assets/avatar/dasher.png");
    private final String name;
    private final int HP;
    private final int speed;
    private final String path;

    Hero(String name, int HP, int speed, String path) {
        this.name = name;
        this.HP = HP;
        this.speed = speed;
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

    public int getHP() {
        return HP;
    }

    public int getSpeed() {
        return speed;
    }

    public static Hero findHero(String name) {
        for (Hero hero : Hero.values()) {
            if (hero.getName().equals(name)) {
                return hero;
            }
        }
        return null;
    }
}
