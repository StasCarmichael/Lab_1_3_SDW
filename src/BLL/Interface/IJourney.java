package BLL.Interface;

public interface IJourney {

    int GetId();

    void SetBus(IBus bus);
    IBus GetInfoAboutBus();

    void SetDriver(IDriver driver);
    IDriver GetInfoAboutDriver();


    boolean JourneyСomplet();

    boolean IsCompleted();
}
