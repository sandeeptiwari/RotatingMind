package com.rotatingmind.guice.player.v1;

import com.rotatingmind.guice.player.IWeapons;

public class Player {
    private IWeapons weaponInHand;

    public void chooseWeapon(int weaponFlag){
        if(weaponFlag == 1){
            weaponInHand = new Gun();
        }else if(weaponFlag ==2){
            weaponInHand = new Rifle();
        }else{
            weaponInHand = new MachineGun();
        }
    }

    public void fireWeapon(){
        if(this.weaponInHand !=null){
            this.weaponInHand.fire();
        }
    }
}
