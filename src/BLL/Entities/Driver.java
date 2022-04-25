package BLL.Entities;

import BLL.Interface.*;

import java.util.LinkedList;

public class Driver implements IDriver {

    private final String name;
    private String driverRank;

    private final LinkedList<IJourney> journeys;


    public Driver(String name, String driverRank) {
        this.name = name;
        this.driverRank = driverRank;

        journeys = new LinkedList<>();
    }


    @Override
    public String GetName() {
        return name;
    }


    @Override
    public String GetDriverRank() {
        return driverRank;
    }

    @Override
    public void SetDriverRank(String rank) {
        driverRank = rank;
    }


    @Override
    public boolean SetRepairRequest(IBus bus, String message) {
        bus.SetRepairRequest(message);

        return  true;
    }

    @Override
    public boolean SetStateInfo(IBus bus, String message) {
        bus.SetStateInfo(message);

        return  true;
    }


    @Override
    public boolean JourneyComplete(int journeyId) {
        for (var joiner : journeys) {
            if (joiner.GetId() == journeyId) {
               return joiner.JourneyСomplet();
            }
        }

        return  false;
    }


    @Override
    public void SetJourney(IJourney journey) {
        journeys.add(journey);
    }

    @Override
    public IJourney[] GetAllJourney() {
        return journeys.toArray(new Journey[journeys.size()]);
    }
}
