package softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.players;

import softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.models.guns.Gun;

import static softuni.OOP.oop_exam_prep.JavaOOPExam12Apr2020.CounterStriker.common.ExceptionMessages.*;

public abstract class PlayerImpl implements Player {

    private String username;
    private int health;
    private int armor;
    private boolean isAlive;
    private Gun gun;

    protected PlayerImpl(String username, int health, int armor, Gun gun) {
        this.setUsername(username);
        this.setHealth(health);
        this.setArmor(armor);
        this.setGun(gun);
        this.setAlive();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public int getArmor() {
        return this.armor;
    }

    @Override
    public Gun getGun() {
        return this.gun;
    }

    @Override
    public boolean isAlive() {
        if (this.health > 0) {
            return true;
        }
        return false;
    }

    @Override
    public void takeDamage(int points) {
        if (this.armor >= points) {
            setArmor(getArmor() - points);
        } else if (this.armor < points) {
            int pointsToTransfer = points - this.armor;
            setArmor(0);
            if (pointsToTransfer > getHealth()) {
                setHealth(0);
            }
            else {
                setHealth(getHealth() - pointsToTransfer);
                if (getHealth() <= 0) {
                    isAlive = false;
                }
            }
        }
    }

    private void setUsername(String username) {
        if (username == null || username.trim().isEmpty()) {
            throw new NullPointerException(INVALID_PLAYER_NAME);
        }
        this.username = username;
    }

    public void setHealth(int health) {
        if (health < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_HEALTH);
        }
        this.health = health;
    }

    public void setArmor(int armor) {
        if (armor < 0) {
            throw new IllegalArgumentException(INVALID_PLAYER_ARMOR);
        }
        this.armor = armor;
    }

    public void setGun(Gun gun) {
        if (gun == null) {
            throw new NullPointerException(INVALID_GUN);
        }
        this.gun = gun;
    }

    private void setAlive() {
        if (getHealth() > 0) {
            this.isAlive = true;
        } else {
            this.isAlive = false;
        }
    }

    @Override
    public String toString() {
        return String.format("%s: %s%n" +
                        "--Health: %d%n" +
                        "--Armor: %d%n" +
                        "--Gun: %s",
                this.getClass().getSimpleName(), this.getUsername(), this.getHealth(),
                this.getArmor(), this.getGun().getName());
    }
}
