package ua.nure.hrynko.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.hrynko.db.dao.MySqlCruisesDAO;
import ua.nure.hrynko.db.models.Cruise;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Slf4j
@Component
public class MyJobProducesCruiseStatusChange {
    @Autowired
   private MySqlCruisesDAO mySqlCruisesDAO;
//    @Autowired
//    private MySqlCruiseHasShipDAO mySqlCruiseHasShipDAO;
    @Transactional
    @Scheduled(cron = "0 0/2 * * * *") // It will run every 2 minutes
    public void execute() {
        log.info("MyJobProducesCruiseStatusChange with transaction starts");
        try {
            List<Cruise> listAllCruise = mySqlCruisesDAO.findAllCruises();
//            List<CruiseHasShip> listCruiseHasShip = mySqlCruiseHasShipDAO.findAllItemsOfCruiseHasShip();

            Calendar calendar = Calendar.getInstance();
            Date currentDate = calendar.getTime();
            long currentDateInMilliseconds = currentDate.getTime();
            log.info("Current data --> " + currentDate);
            for (Cruise itemCruise : listAllCruise) {
                //дата начала
                long cruiseStartInMilliseconds = itemCruise.getStartOfCruise().getTime();
                log.info("Start cruise data--> " + itemCruise.getStartOfCruise());
                //устанавливаем дату, с которой будет производится операция
                calendar.setTime(itemCruise.getStartOfCruise());
                // прибавляем кол дней = значению поля duration к установленной дате
                calendar.add(Calendar.DAY_OF_MONTH, itemCruise.getDuration());
                long cruiseFinishInMilliseconds = calendar.getTime().getTime();
                log.info("Finish cruise data--> " + calendar.getTime());

                if (currentDateInMilliseconds <= cruiseStartInMilliseconds) {
                    itemCruise.setStatus("Не начался");
                    mySqlCruisesDAO.update(itemCruise);
                    log.info("Change status item on cruise DB--> " + "Not started");
                }
                if (currentDateInMilliseconds >= cruiseStartInMilliseconds &&
                        currentDateInMilliseconds < cruiseFinishInMilliseconds) {
                    itemCruise.setStatus("Начался");
                    mySqlCruisesDAO.update(itemCruise);
                    log.info("Change status item on cruise DB--> " + "Started");
                }
                if (currentDateInMilliseconds >= cruiseFinishInMilliseconds) {
                    itemCruise.setStatus("Закончился");
                    mySqlCruisesDAO.update(itemCruise);
                    log.info("Change status item on cruise DB--> " + "Ended");
                }
            }
//            for (CruiseHasShip itemCruiseHasShip : listCruiseHasShip) {
//                long contractEndInMilliseconds = itemCruiseHasShip.getEndOfContract().getTime();
//                log.trace("End contract data--> " + itemCruiseHasShip.getEndOfContract());
//                if(currentDateInMilliseconds >= contractEndInMilliseconds){
//                    itemCruiseHasShip.setStatus("Закончился");
//                    mySqlCruiseHasShipDAO.updateCruiseHasShipDb(con, itemCruiseHasShip);
//                    log.trace("Change status item on cruise_has_ship DB --> " + "Закончился");
//                }
//                if(currentDateInMilliseconds < contractEndInMilliseconds){
//                    itemCruiseHasShip.setStatus("Действующий");
//                    mySqlCruiseHasShipDAO.updateCruiseHasShipDb(con, itemCruiseHasShip);
//                    log.trace("Change status item on cruise_has_ship DB --> " + "Действующий");
//                }
//            }
        } catch (Exception ex) {
            log.error("cannot change status cruise", ex);
        }
        log.info("MyJobProducesCruiseStatusChange with transaction finished");
    }
}
