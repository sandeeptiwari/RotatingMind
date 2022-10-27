package com.rotatingmind.guice.player.v2;

import com.rotatingmind.guice.player.IWeapons;

public class Player {

    private IWeapons weaponInHand;

    public void chooseWeapon(IWeapons setWeapons){
        this.weaponInHand = setWeapons;
    }

    public void fireWeapon(){
        if(this.weaponInHand !=null){
            this.weaponInHand.fire();
        }
    }
}
