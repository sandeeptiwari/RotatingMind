package com.sandi.ocp;
import static  my.sports.FootBall.*;

enum Beer{
	KF, KO,RC,FO;
	
	Beer() {
	  System.out.println("I am enum constructor");
	}
}

public class Test {

	public static void main(String[] args) {
		Beer b = Beer.KF;
		Beer b1 = Beer.KO;
		System.out.println("Hi I am main"+TEAM_SIZE);
	}

}
