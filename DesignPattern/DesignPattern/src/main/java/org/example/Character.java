package org.example;

import java.util.Random;

public class Character {
    private State currentState;

    public Character() {
        this.currentState = new NormalState();
        System.out.println("Charactére créé dans l'état normal.");
    }
    public void setState(State state) {
        this.currentState = state;
    }

    public void attack() {
        this.currentState.attack();
    }

    public void move() {
        this.currentState.move();
    }
    public void healCharacter() {
        if (currentState instanceof NormalState) {
            System.out.println("Charactére guéri.");
        } else {
            System.out.println("La guérison ne peut être effectuée qu'à l'état normal.");
        }
}
    public void enrageCharacter() {
        System.out.println("Charactére enragé.");
        this.currentState = new EnragedState();
    }

    public void poisonCharacter() {
        System.out.println("Charactére empoisonné.");
        this.currentState = new PoisonedState();
    }

    public void attackCharacter(Character target) {
        Random random = new Random();
        int randomValue = random.nextInt(100);

        if (randomValue < 30) {
            this.currentState = new EnragedState();
            System.out.println("L'attaquant devient Enragé.");
        } else if (randomValue < 60) {
            target.setState(new EnragedState());
            System.out.println("La cible devient Enragée.");
        } else {
            System.out.println("Attaque réussie sans changement d'état.");
        }
    }
}
