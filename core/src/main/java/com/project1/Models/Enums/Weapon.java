package com.project1.Models.Enums;

public enum Weapon {
    REVOLVER(
        "Revolver",
        6,    // Ammo Max
        15,   // Reload Time (ms)
        20,    // Damage
        1      // Projectile Count
    ),
    SHOTGUN(
        "Shotgun",
        2,
        15,
        10,
        4
    ),
    SMG_DUAL(
        "SMGs Dual",
        24,
        25,
        8,
        1
    );

    private final String displayName;
    private final int maxAmmo;
    private final int reloadTime;
    private final int damage;
    private final int projectileCount;

    Weapon(String displayName, int maxAmmo, int reloadTime, int damage, int projectileCount) {
        this.displayName = displayName;
        this.maxAmmo = maxAmmo;
        this.reloadTime = reloadTime;
        this.damage = damage;
        this.projectileCount = projectileCount;
    }

    public String getDisplayName() { return displayName; }
    public int getMaxAmmo() { return maxAmmo; }
    public int getReloadTime() { return reloadTime; }
    public int getDamage() { return damage; }
    public int getProjectileCount() { return projectileCount; }

    public static Weapon findWeapon(String displayName) {
        for (Weapon weapon : values()) {
            if (weapon.displayName.equalsIgnoreCase(displayName)) {
                return weapon;
            }
        }
        return null;
    }
}
