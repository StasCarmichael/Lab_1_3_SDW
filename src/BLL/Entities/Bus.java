package BLL.Entities;

import BLL.Interface.*;

import java.util.LinkedList;

public class Bus implements IBus {

    private final String modelName;

    private LinkedList<String> repairRequest;
    private LinkedList<String> stateInfo;


    public Bus(String modelName) {
        repairRequest = new LinkedList<>();
        stateInfo = new LinkedList<>();

        this.modelName = modelName;
    }


    @Override
    public String GetModelName() {
        return modelName;
    }


    @Override
    public void SetStateInfo(String info) {
        stateInfo.add(info);
    }
    @Override
    public String[] GetStateInfo() {
        return stateInfo.toArray(new String[0]);
    }


    @Override
    public void SetRepairRequest(String message) {
        repairRequest.add(message);
    }
    @Override
    public String[] GetRepairRequest() {
        return repairRequest.toArray(new String[0]);
    }
    @Override
    public void Repair() {
        repairRequest.clear();
    }
}
