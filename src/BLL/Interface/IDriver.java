package BLL.Interface;

public interface IDriver {

    String GetName();


    String GetDriverRank();

    void SetDriverRank(String rank);


    boolean SetRepairRequest(IBus bus, String message);

    boolean SetStateInfo(IBus bus, String message);

    boolean JourneyComplete(int journeyId);


    void SetJourney(IJourney journey);

    IJourney[] GetAllJourney();
}
