package oops.overriding;

public class VIPMember implements Member, IOrganizer {

    @Override
    public void organize() {
        System.out.println("Organize the session");
    }

    @Override
    public void watch() {
        System.out.println("Enjoy the tournament");
    }

}
