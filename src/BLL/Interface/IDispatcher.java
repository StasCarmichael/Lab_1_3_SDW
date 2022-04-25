package BLL.Interface;

public interface IDispatcher {

    void AddJourney(IDriver driver , IBus bus);

    IJourney[] GetAllJourney();

    boolean ChangeDriver(int journeyId, IDriver driver );

}
