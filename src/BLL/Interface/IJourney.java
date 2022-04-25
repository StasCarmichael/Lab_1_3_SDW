package BLL.Interface;

public interface IJourney {

    int GetIndex();

    IBus GetInfoAboutBus();

    IDriver GetInfoAboutDriver();


    boolean JourneyСomplet();
    boolean IsCompleted();
}
