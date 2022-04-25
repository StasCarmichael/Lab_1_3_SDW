package BLL.Interface;

public interface IBus {

    String GetModelName();


    void SetStateInfo(String info);

    String[] GetStateInfo();


    void SetRepairRequest(String message);

    String[] GetRepairRequest();

    void Repair();

}
