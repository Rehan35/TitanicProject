
import java.util.HashMap;
import java.util.Map;

public class TitanicScoring {
    
    private static Titanic.Class getMissingPClass(Titanic.Passenger passenger) {
        Map<Titanic.Class, Integer> pClassMap = new HashMap<>();
        pClassMap.put(Titanic.Class.FIRST, 0);
        pClassMap.put(Titanic.Class.SECOND, 0);
        pClassMap.put(Titanic.Class.THIRD, 0);
        for (Titanic.Passenger trainPassenger : TitanicTrainingData.passengers) {
            if (trainPassenger.sex() != Titanic.Sex.UNKNOWN && trainPassenger.sex() == passenger.sex()) {
                pClassMap.put(trainPassenger.pclass(), pClassMap.get(trainPassenger.pclass()) + 1);
            }
            if (trainPassenger.port() != Titanic.Port.UNKNOWN && trainPassenger.port() == passenger.port()) {
                pClassMap.put(trainPassenger.pclass(), pClassMap.get(trainPassenger.pclass()) + 1);
            }
            if (trainPassenger.age() != -1 && Math.abs(trainPassenger.age() - passenger.age()) <= 5) {
                pClassMap.put(trainPassenger.pclass(), pClassMap.get(trainPassenger.pclass()) + 1);
            }
            //siblings, parents, fare
            if (trainPassenger.siblings() != -1 && Math.abs(trainPassenger.siblings() - passenger.siblings()) <= 1) {
                pClassMap.put(trainPassenger.pclass(), pClassMap.get(trainPassenger.pclass()) + 1);
            }
            if (trainPassenger.parents() != -1 && Math.abs(trainPassenger.parents() - passenger.parents()) <= 1) {
                pClassMap.put(trainPassenger.pclass(), pClassMap.get(trainPassenger.pclass()) + 1);
            }
            if (trainPassenger.fare() != -1 && Math.abs(trainPassenger.fare() - passenger.fare()) <= 10) {
                pClassMap.put(trainPassenger.pclass(), pClassMap.get(trainPassenger.pclass()) + 1);
            }
        }
        
        int maxCount = pClassMap.get(Titanic.Class.SECOND);
        Titanic.Class finalClass = Titanic.Class.SECOND;
        for (Titanic.Class pClass : Titanic.Class.values()) {
            if (pClassMap.get(pClass) > maxCount) {
                maxCount = pClassMap.get(pClass);
                finalClass = pClass;
            }
        }
        return finalClass;
    }
    
    private static Titanic.Port getMissingPort(Titanic.Passenger passenger) {
        Map<Titanic.Port, Integer> portMap = new HashMap<>();
        portMap.put(Titanic.Port.SOUTHAMPTON, 0);
        portMap.put(Titanic.Port.CHERBOURG, 0);
        portMap.put(Titanic.Port.QUEENSTOWN, 0);
        portMap.put(Titanic.Port.UNKNOWN, 0);
        for (Titanic.Passenger trainPassenger : TitanicTrainingData.passengers) {
            if (trainPassenger.port() != Titanic.Port.UNKNOWN) {
                if (trainPassenger.sex() != Titanic.Sex.UNKNOWN && trainPassenger.sex() == passenger.sex()) {
                    portMap.put(trainPassenger.port(), portMap.get(trainPassenger.port()) + 1);
                }
                if (trainPassenger.pclass() != Titanic.Class.UNKNOWN && trainPassenger.pclass() == passenger.pclass()) {
                    portMap.put(trainPassenger.port(), portMap.get(trainPassenger.port()) + 1);
                }
                if (trainPassenger.age() != -1 && Math.abs(trainPassenger.age() - passenger.age()) <= 5) {
                    portMap.put(trainPassenger.port(), portMap.get(trainPassenger.port()) + 1);
                }
                //siblings, parents, fare
                if (trainPassenger.siblings() != -1 && Math.abs(trainPassenger.siblings() - passenger.siblings()) <= 1) {
                    portMap.put(trainPassenger.port(), portMap.get(trainPassenger.port()) + 1);
                }
                if (trainPassenger.parents() != -1 && Math.abs(trainPassenger.parents() - passenger.parents()) <= 1) {
                    portMap.put(trainPassenger.port(), portMap.get(trainPassenger.port()) + 1);
                }
                if (trainPassenger.fare() != -1 && Math.abs(trainPassenger.fare() - passenger.fare()) <= 10) {
                    portMap.put(trainPassenger.port(), portMap.get(trainPassenger.port()) + 1);
                }
            }
        }
        
        int maxCount = portMap.get(Titanic.Port.SOUTHAMPTON);
        Titanic.Port finalPort = Titanic.Port.SOUTHAMPTON;
        for (Titanic.Port port : Titanic.Port.values()) {
            if (portMap.get(port) > maxCount) {
                maxCount = portMap.get(port);
                finalPort = port;
            }
        }
        return finalPort;
    }
    
    private static int getMissingAge(Titanic.Passenger passenger) {
        int finalAge = 30;
        int n = 1;
        for (Titanic.Passenger trainPassenger : TitanicTrainingData.passengers) {
            if (trainPassenger.sex() != Titanic.Sex.UNKNOWN && trainPassenger.sex() == passenger.sex()) {
                finalAge += trainPassenger.age();
                n++;
            }
            if (trainPassenger.port() != Titanic.Port.UNKNOWN && trainPassenger.port() == passenger.port()) {
                finalAge += trainPassenger.age();
                n++;
            }
            if (trainPassenger.pclass() != Titanic.Class.UNKNOWN && trainPassenger.pclass() == passenger.pclass()) {
                finalAge += trainPassenger.age();
                n++;
            }
            //siblings, parents, fare
            if (trainPassenger.siblings() != -1 && Math.abs(trainPassenger.siblings() - passenger.siblings()) <= 1) {
                finalAge += trainPassenger.age();
                n++;
            }
            if (trainPassenger.parents() != -1 && Math.abs(trainPassenger.parents() - passenger.parents()) <= 2) {
                finalAge += trainPassenger.age();
                n++;
            }
            if (trainPassenger.fare() != -1 && Math.abs(trainPassenger.fare() - passenger.fare()) <= 10) {
                finalAge += trainPassenger.age();
                n++;
            }
        }
        
        return (int) finalAge/n;
    }
    
    private static int getMissingSiblings(Titanic.Passenger passenger) {
        int finalSiblings = 1;
        int n = 1;
        for (Titanic.Passenger trainPassenger : TitanicTrainingData.passengers) {
            if (trainPassenger.sex() != Titanic.Sex.UNKNOWN && trainPassenger.sex() == passenger.sex()) {
                finalSiblings += trainPassenger.siblings();
                n++;
            }
            if (trainPassenger.port() != Titanic.Port.UNKNOWN && trainPassenger.port() == passenger.port()) {
                finalSiblings += trainPassenger.siblings();
                n++;
            }
            if (trainPassenger.pclass() != Titanic.Class.UNKNOWN && trainPassenger.pclass() == passenger.pclass()) {
                finalSiblings += trainPassenger.siblings();
                n++;
            }
            //siblings, parents, fare
            if (trainPassenger.age() != -1 && Math.abs(trainPassenger.age() - passenger.age()) <= 5) {
                finalSiblings += trainPassenger.siblings();
                n++;
            }
            if (trainPassenger.parents() != -1 && Math.abs(trainPassenger.parents() - passenger.parents()) <= 1) {
                finalSiblings += trainPassenger.siblings();
                n++;
            }
            if (trainPassenger.fare() != -1 && Math.abs(trainPassenger.fare() - passenger.fare()) <= 10) {
                finalSiblings += trainPassenger.siblings();
                n++;
            }
        }
        
        return (int) (finalSiblings/n);
    }
    
    private static int getMissingParents(Titanic.Passenger passenger) {
        int finalParents = 0;
        int n = 1;
        for (Titanic.Passenger trainPassenger : TitanicTrainingData.passengers) {
            if (trainPassenger.sex() != Titanic.Sex.UNKNOWN && trainPassenger.sex() == passenger.sex()) {
                finalParents += trainPassenger.parents();
                n++;
            }
            if (trainPassenger.port() != Titanic.Port.UNKNOWN && trainPassenger.port() == passenger.port()) {
                finalParents += trainPassenger.parents();
                n++;
            }
            if (trainPassenger.pclass() != Titanic.Class.UNKNOWN && trainPassenger.pclass() == passenger.pclass()) {
                finalParents += trainPassenger.parents();
                n++;
            }
            //siblings, parents, fare
            if (trainPassenger.age() != -1 && Math.abs(trainPassenger.age() - passenger.age()) <= 5) {
                finalParents += trainPassenger.parents();
                n++;
            }
            if (trainPassenger.parents() != -1 && Math.abs(trainPassenger.siblings() - passenger.siblings()) <= 1) {
                finalParents += trainPassenger.parents();
                n++;
            }
            if (trainPassenger.fare() != -1 && Math.abs(trainPassenger.fare() - passenger.fare()) <= 10) {
                finalParents += trainPassenger.parents();
                n++;
            }
        }
        
        return (int) (finalParents/n);
    }
    
    private static double getMissingFare(Titanic.Passenger passenger) {
        double finalFare = 33.04;
        int n = 1;
        for (Titanic.Passenger trainPassenger : TitanicTrainingData.passengers) {
            if (trainPassenger.sex() != Titanic.Sex.UNKNOWN && trainPassenger.sex() == passenger.sex()) {
                finalFare += trainPassenger.fare();
                n++;
            }
            if (trainPassenger.port() != Titanic.Port.UNKNOWN && trainPassenger.port() == passenger.port()) {
                finalFare += trainPassenger.fare();
                n++;
            }
            if (trainPassenger.pclass() != Titanic.Class.UNKNOWN && trainPassenger.pclass() == passenger.pclass()) {
                finalFare += trainPassenger.fare();
                n++;
            }
            //siblings, parents, fare
            if (trainPassenger.age() != -1 && Math.abs(trainPassenger.age() - passenger.age()) <= 5) {
                finalFare += trainPassenger.fare();
                n++;
            }
            if (trainPassenger.parents() != -1 && Math.abs(trainPassenger.siblings() - passenger.siblings()) <= 1) {
                finalFare += trainPassenger.fare();
                n++;
            }
            if (trainPassenger.fare() != -1 && Math.abs(trainPassenger.parents() - passenger.parents()) <= 1) {
                finalFare += trainPassenger.siblings();
                n++;
            }
        }
        
        return finalFare/n;
    }
    
    

    public static boolean survived(Titanic.Passenger passenger) {
        
        if (passenger.pclass() == Titanic.Class.UNKNOWN) {
            passenger = new Titanic.Passenger(passenger.id(), passenger.name(), passenger.survived(), passenger.port(), TitanicScoring.getMissingPClass(passenger), passenger.sex(), 
                    passenger.age(), passenger.siblings(), passenger.parents(), passenger.fare());
        } 
        
        if (passenger.port() == Titanic.Port.UNKNOWN) {
            passenger = new Titanic.Passenger(passenger.id(), passenger.name(), passenger.survived(), TitanicScoring.getMissingPort(passenger), passenger.pclass(), passenger.sex(), 
                    passenger.age(), passenger.siblings(), passenger.parents(), passenger.fare());
        }
        if (passenger.age() == (-1)) {
            passenger = new Titanic.Passenger(passenger.id(), passenger.name(), passenger.survived(), passenger.port(), passenger.pclass(), passenger.sex(), 
                    TitanicScoring.getMissingAge(passenger), passenger.siblings(), passenger.parents(), passenger.fare());
        }
        if (passenger.siblings() == (-1)) {
            passenger = new Titanic.Passenger(passenger.id(), passenger.name(), passenger.survived(), passenger.port(), passenger.pclass(), passenger.sex(), 
                    passenger.age(), TitanicScoring.getMissingSiblings(passenger), passenger.parents(), passenger.fare());
        }
        if (passenger.parents()  == (-1)) {
            passenger = new Titanic.Passenger(passenger.id(), passenger.name(), passenger.survived(), passenger.port(), passenger.pclass(), passenger.sex(), 
                    passenger.age(), passenger.siblings(), TitanicScoring.getMissingParents(passenger), passenger.fare());
        }
        if (passenger.fare()  == (-1)) {
            passenger = new Titanic.Passenger(passenger.id(), passenger.name(), passenger.survived(), passenger.port(), passenger.pclass(), passenger.sex(), 
                    passenger.age(), passenger.siblings(), passenger.parents(), passenger.fare());
        }
        
        if (passenger.sex() == Titanic.Sex.FEMALE) {
            if (passenger.pclass() == Titanic.Class.FIRST) {
                
                if (passenger.age() == TitanicTrainingData.NA) {
                    
                }
                
                if (passenger.age() < 10) {
                    return false;
                } else if (passenger.age() >= 10) {
                    if (passenger.fare() >= 50) {
                        if (passenger.parents() >= 0 && passenger.parents() <= 1) {
                            return true;
                        } else if (passenger.parents() == 2) {
                            if (passenger.siblings() >= 0 && passenger.siblings() <= 3 && passenger.siblings() != 1) {
                                return true;
                            } else if (passenger.siblings() == 1) {
                                return true;
                            } else if (passenger.siblings() > 4) {
                                return false;
                            }
                        } else if (passenger.parents() > 3) {
                            return false;
                        }
                    } else if (passenger.fare() < 50) {
                        if (passenger.port() == Titanic.Port.SOUTHAMPTON) {
                            return true;
                        } else if (passenger.port() == Titanic.Port.CHERBOURG) {
                           return true;
                        } else if (passenger.port() == Titanic.Port.QUEENSTOWN) {
                            return false;
                        } 
                    }
                }
                
            } else if (passenger.pclass() == Titanic.Class.SECOND) {
                
                if (passenger.parents() == 2 || passenger.parents() == 3) {
                    return true;
                } else if (passenger.parents() >= 4 && passenger.parents() <= 6) {
                    return false;
                } else if (passenger.parents() == 0) {
                    if (passenger.port() == Titanic.Port.SOUTHAMPTON) {
                        return true;
                    } else if (passenger.port() == Titanic.Port.CHERBOURG || passenger.port() == Titanic.Port.QUEENSTOWN) {
                        return true;
                    }
                } else if (passenger.parents() == 1) {
                    if (passenger.siblings() >= 0 && passenger.siblings() <= 2 && passenger.siblings() != 1) {
                        return true;
                    } else if (passenger.siblings() == 1) {
                        return true;
                    } else if (passenger.siblings() > 2) {
                        return false;
                    }
                }
                
            } else if (passenger.pclass() == Titanic.Class.THIRD) {
                
                if (passenger.age() >= 10) {
                    if (passenger.siblings() == 0) {
                        if (passenger.parents() == 0) {
                            
                            if (passenger.port() == Titanic.Port.SOUTHAMPTON) {
                                if (passenger.fare() >= 50) {
                                    return false;
                                } else if (passenger.fare() < 50) {
                                    return true;
                                }
                            } else if (passenger.port() == Titanic.Port.CHERBOURG) {
                                return true;
                            } else if (passenger.port() == Titanic.Port.QUEENSTOWN) {
                                return false;
                            }
                            
                            
                        } else if (passenger.parents() == 1 || passenger.parents() == 5) {
                            return true; //50/50
                        } else if (passenger.parents() == 2 || passenger.parents() == 3 || passenger.parents() == 4 || passenger.parents() == 6) {
                            return false;
                        }
                    } else if (passenger.siblings() == 1) {
                        if (passenger.parents() == 0) {
                            
                            if (passenger.port() == Titanic.Port.SOUTHAMPTON) {
                                if (passenger.fare() >= 50) {
                                    return false;
                                } else if (passenger.fare() < 50) {
                                    return true;
                                }
                            } else if (passenger.port() == Titanic.Port.CHERBOURG) {
                                return false;
                            } else if (passenger.port() == Titanic.Port.QUEENSTOWN) {
                                return false;
                            }
                            
                            
                        } else if (passenger.parents() == 1 || passenger.parents() == 5) {
                            return false;
                        } else if (passenger.parents() == 2 || passenger.parents() == 3 || passenger.parents() == 4 || passenger.parents() == 6) {
                            return false;
                        }
                    } else if (passenger.siblings() == 2 || passenger.siblings() == 5 || passenger.siblings() == 8) {
                        return false;
                    } else if (passenger.siblings() == 3) {
                        return true;
                    } else if (passenger.siblings() == 4) {
                        return false;
                    }
                } else if (passenger.age() < 10) {
                    if (passenger.siblings() == 0) {
                        if (passenger.parents() == 0 || passenger.parents() == 2) {
                            return true;
                        } else if (passenger.parents() == 1) {
                            return true;
                        } else if (passenger.parents() > 3) {
                            return false;
                        }
                    } else if (passenger.siblings() == 2) {
                        if (passenger.port() == Titanic.Port.SOUTHAMPTON || passenger.port() == Titanic.Port.QUEENSTOWN) {
                            return false;
                        } else if (passenger.port() == Titanic.Port.CHERBOURG) {
                            return true;
                        }
                    } else if (passenger.siblings() == 3 || passenger.siblings() == 5 || passenger.siblings() == 8) {
                        return false;
                    } else if (passenger.siblings() == 1) {
                        return true;
                    } else if (passenger.siblings() == 4) {
                        if (passenger.port() == Titanic.Port.CHERBOURG || passenger.port() == Titanic.Port.QUEENSTOWN) {
                            return false;
                        } else if (passenger.port() == Titanic.Port.SOUTHAMPTON) {
                            return false;
                        }
                    }
                }
                
            } else if (passenger.pclass() == Titanic.Class.UNKNOWN) {
                
            }
        } else if (passenger.sex() == Titanic.Sex.MALE) {
            if (passenger.pclass() == Titanic.Class.FIRST) {
                if (passenger.age() >= 50) {
                    if (passenger.siblings() == 0 || passenger.siblings() > 2 || passenger.siblings() == 1) {
                        return false;
                    } else if (passenger.siblings() == 2) {
                        return true;
                    }
                } else if (passenger.age() < 50) {
                    if (passenger.age() >= 10) {
                        if (passenger.siblings() == 0) {
                            return false; //50/50
                        } else if (passenger.siblings() == 1) {
                            return true; //50/50
                        } else if (passenger.siblings() > 1) {
                            return false;
                        }
                    } else if (passenger.age() < 10) {
                        return true;
                    }
                }
            } else if (passenger.pclass() == Titanic.Class.SECOND) {
                if (passenger.age() >= 10) {
                    if (passenger.age() >= 30) {
                        return false;
                    } else if (passenger.age() < 30) {
                        return false;
                    }
                } else if (passenger.age() < 10) {
                    return true;
                }
            } else if (passenger.pclass() == Titanic.Class.THIRD) {
                if (passenger.fare() >= 50) {
                    if (passenger.siblings() == 0) {
                        return true;
                    } else if (passenger.siblings() > 0) {
                        return false;
                    }
                } else if (passenger.fare() < 50) {
                    return false;
                }
            }
        }
        
        return false;
    }

    public static void main(String[] args) {
        int countTrue = 0;
        int countAll = 0;
        for (Titanic.Passenger passenger : TitanicTestingData.passengers) {
            try {
                boolean survived = survived(passenger);
                System.out.println(passenger.id() + "," + survived);
                if (survived) {
                    countTrue++;
                }
                countAll++;
            } catch (Exception e) {
                System.out.println(e);
                System.out.println(passenger.id() + ",null");
            }
        }
        System.out.println((double) (countTrue)/countAll);
    }
}
