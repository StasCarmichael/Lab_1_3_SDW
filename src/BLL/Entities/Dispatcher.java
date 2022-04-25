package BLL.Entities;

import BLL.Interface.*;

import java.util.LinkedList;

public class Dispatcher implements IDispatcher {

    private final LinkedList<IJourney> journeys;

    public Dispatcher() {
        journeys = new LinkedList<>();
    }

    @Override
    public void AddJourney(IDriver driver, IBus bus) {
        journeys.add(new Journey(bus, driver));
    }

    @Override
    public IJourney[] GetAllJourney() {
        return journeys.toArray(new Journey[journeys.size()]);
    }

    @Override
    public boolean ChangeDriver(int journeyId, IDriver driver) {
        for (var jour : journeys) {
            if (jour.GetId() == journeyId) {
                jour.SetDriver(driver);
                return true;
            }
        }

        return false;
    }
}
