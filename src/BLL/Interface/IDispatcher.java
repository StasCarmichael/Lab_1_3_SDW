package BLL.Interface;

public interface IDispatcher {

    void AddJourney(IDriver driver , IBus bus);

    boolean ChangeDriver(int JourneyID, IDriver driver );

    IJourney[] GetAllJourney();
}
