package BLL.Interface;

public interface IBus {

    String GetModelName();


    void SetStateInfo(String info);

    String[] SetStateInfo();


    void SetRepairRequest(String message);

    String[] GetRepairRequest();

    void Repair();

}
