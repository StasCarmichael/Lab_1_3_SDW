package Project;

import BLL.Interface.*;
import BLL.Entities.*;

import java.util.LinkedList;
import java.util.function.Predicate;

public class Main {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher();

        var driver1 = new Driver("Stas", "master");
        var bus1 = new Bus("MAN");
        var driver2 = new Driver("Alex", "intern");
        var bus2 = new Bus("KPAZ");

        dispatcher.AddJourney(driver1, bus1);
        dispatcher.AddJourney(driver2, bus2);
        dispatcher.AddJourney(driver1, bus1);

        //Print data first time
        printDispatcher(dispatcher);


        System.out.println("%%%%%%%%% ADD NEW MESSAGE IN PROGRAM %%%%%%%%%");

        var data = Predicter(dispatcher, val -> val.GetId() == 1).getFirst();
        data.GetInfoAboutDriver().SetRepairRequest(data.GetInfoAboutBus(), "Трансмісія працює з перебоями");
        data.GetInfoAboutDriver().SetStateInfo(data.GetInfoAboutBus(), "Все працює коректно, рейс успішно завершено");

        System.out.println("Водій додаємо заявку на ремонт, та повідомляє про стан мшини");

        data = Predicter(dispatcher, val -> val.GetId() == 0).getFirst();
        data.GetInfoAboutDriver().SetStateInfo(data.GetInfoAboutBus(), "Рейс успішно виконано можливо потбірно замінити масло");
        //Print data second time
        printDispatcher(dispatcher);


        System.out.println("%%%%%%%%% CHANGE DRIVER and ADD NEW MESSAGE %%%%%%%%%");

        var driver3 = new Driver("Victor", "profecional");

        dispatcher.ChangeDriver(1, driver3);
        data = Predicter(dispatcher, val -> val.GetId() == 1).getFirst();
        data.GetInfoAboutDriver().JourneyComplete(data.GetId());
        data.GetInfoAboutDriver().SetStateInfo(data.GetInfoAboutBus(), "Рейс повністю виконана");
        data.GetInfoAboutDriver().SetRepairRequest(data.GetInfoAboutBus(), "Непрацює права верхня дверка");
        data = Predicter(dispatcher, val -> val.GetId() == 2).getFirst();
        data.GetInfoAboutDriver().SetRepairRequest(data.GetInfoAboutBus(), "Проблеми з трансмісією");

        System.out.println("Диспетчер замінює, водія, також новий водій виконує рейс і додає стан про машину");
        //Print data thirt time
        printDispatcher(dispatcher);


        System.out.println("%%%%%%%%% ADD new JOURNEY, CHANGE DRIVER and finish JOURNEY %%%%%%%%%");

        var bus3 = new Bus("Mersedes");
        System.out.println("Додаємо новий рейс");
        dispatcher.AddJourney(driver3, bus3);
        dispatcher.ChangeDriver(0, driver2);
        data = Predicter(dispatcher, val -> val.GetId() == 0).getFirst();
        data.GetInfoAboutDriver().JourneyComplete(data.GetId());
        data.GetInfoAboutDriver().SetStateInfo(data.GetInfoAboutBus(), "РЕЙС завершено");
        data.GetInfoAboutDriver().SetRepairRequest(data.GetInfoAboutBus(), "Непрацює скла очистник");

        System.out.println("Поремонтував машину яка виконує рейс номер 2");
        data = Predicter(dispatcher, val -> val.GetId() == 2).getFirst();
        data.GetInfoAboutBus().Repair();
        //Print data fourth time
        printDispatcher(dispatcher);
    }


    private static LinkedList<IJourney> Predicter(IDispatcher dispatcher, Predicate<IJourney> journeyPredicate) {
        var res = new LinkedList<IJourney>();

        for (var data : dispatcher.GetAllJourney()) {
            if (journeyPredicate.test(data)) {
                res.add(data);
            }
        }

        return res;
    }


    private static void printDispatcher(IDispatcher dispatcher) {
        var data = dispatcher.GetAllJourney();
        for (int i = 0; i < data.length; i++) {
            printJourney(data[i]);
        }
    }

    private static void printJourney(IJourney journey) {
        System.out.println("/////////////////////// Print JOURNEY //////////////////////");

        System.out.println("Id = " + journey.GetId());
        printBus(journey.GetInfoAboutBus());
        printDriver(journey.GetInfoAboutDriver());
        System.out.println("IsCompleted = " + journey.IsCompleted());

        System.out.println("////////////////////////////////////////////////////////////");
    }

    private static void printDriver(IDriver driver) {
        System.out.println("+++++++++++++++++++++ Print DRIVER +++++++++++++++++++++");

        System.out.println("Name = " + driver.GetName());
        System.out.println("Driver rank = " + driver.GetDriverRank());

        int i = 0;
        for (var data : driver.GetAllJourney()) {
            System.out.println("\tJourney " + i + " ID = " + data.GetId());
        }

        System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private static void printBus(IBus bus) {
        System.out.println("===================== Print BUS =======================");

        System.out.println("Model name  = " + bus.GetModelName());

        int i = 0;
        for (var str : bus.GetStateInfo()) {
            System.out.println("\tInfo " + i + " = " + str);
            i++;
        }

        i = 0;
        for (var str : bus.GetRepairRequest()) {
            System.out.println("\tRepairRequest " + i + " = " + str);
            i++;
        }

        System.out.println("========================================================");
    }

}
