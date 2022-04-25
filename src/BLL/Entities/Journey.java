package BLL.Entities;

import BLL.Interface.*;

public class Journey implements IJourney {

    private static int startId = 0;
    private final int id;

    private IBus bus;
    private IDriver driver;

    private boolean complet;


    public Journey(IBus bus, IDriver driver) {
        id = startId++;

        this.bus = bus;
        this.driver = driver;
        driver.SetJourney(this);

        complet = false;
    }


    @Override
    public int GetId() {
        return id;
    }


    @Override
    public void SetBus(IBus bus) {
        this.bus = bus;
    }

    @Override
    public IBus GetInfoAboutBus() {
        return bus;
    }


    @Override
    public void SetDriver(IDriver driver) {
        this.driver = driver;
        driver.SetJourney(this);
    }

    @Override
    public IDriver GetInfoAboutDriver() {
        return driver;
    }


    @Override
    public boolean JourneyСomplet() {
        if (complet) {
            return false;
        } else {
            complet = true;
            return true;
        }
    }

    @Override
    public boolean IsCompleted() {
        return complet;
    }
}
