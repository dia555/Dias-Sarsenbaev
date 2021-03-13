package com.company;

public interface CostCalculator {
    default int bills(int visits, int costPerVisit){
        return visits*costPerVisit;
    }
}


