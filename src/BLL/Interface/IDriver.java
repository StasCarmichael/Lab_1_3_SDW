package BLL.Interface;

public interface IDriver {

    String GetName();


    String GetDriverRank();

    void SetDriverRank(String rank);


    boolean SetRepairRequest(IDriver driver, String message);


    IJourney[] GetAllJourney();
}
