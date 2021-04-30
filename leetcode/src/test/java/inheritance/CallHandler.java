package others.inheritance;

import java.util.*;

public class CallHandler {

    List<Set<Employee>> employees=new LinkedList<>();


    public CallHandler() {
        Set<Employee> el1=new HashSet<>();
        Set<Employee> el2=new HashSet<>();
        Set<Employee> el3=new HashSet<>();
        employees.add(el1);
        employees.add(el2);
        employees.add(el3);
    }

    public Employee dispatchCall(){
        for (Set<Employee> employeesAtLvl:employees){
            Optional<Employee> employeeOpt = employeesAtLvl.stream().filter(e->!e.isBusy()).findAny();
            if(employeeOpt.isPresent()){
                employeeOpt.get().setBusy(true);
                return employeeOpt.get();
            }
        }
        return null;
    }

}
