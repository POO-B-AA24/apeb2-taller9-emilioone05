package ejercicio1.pkg4;

import java.util.ArrayList;
import java.util.List;

// Ejemplo de uso
public class WorkerSystem {
    public static void main(String[] args) {
        Boss boss = new Boss("Daniel", "Irene", "24 de Mayo", "1105819153", 3000);
        Mensuality mensualWorker = new Mensuality("Ruth", "Reategui", "Av. Cuxibamba", "1102867395", boss, 2000);
        CommissionAgent commissionWorker = new CommissionAgent("Pedro", "Yepez", "Av. Orillas del Zamora", "119647253", boss, 0.1);
        ByHours hourlyWorker = new ByHours("Jeank", "Cuenca", "Av. Manuel Agustin Aguirre", "114556956", boss, 20, 30);

        PayRollWorkers payroll = new PayRollWorkers();
        payroll.dischargeWork(mensualWorker);
        payroll.dischargeWork(commissionWorker);
        payroll.dischargeWork(hourlyWorker);

        // Fijar ventas y horas trabajadas
        payroll.setHourSales(commissionWorker, 20000);
        payroll.setHourSales(hourlyWorker, 45);

        // Imprimir nómina
        payroll.printPayRoll();
    }
}

// Clase PayRollWorkers
class PayRollWorkers {
    private List<Worker> workers;

    public PayRollWorkers() {
        this.workers = new ArrayList<>();
    }

    public void dischargeWork(Worker worker) {
        workers.add(worker);
    }

    public void setHourSales(Worker worker, double value) {
        if (worker instanceof CommissionAgent) {
            ((CommissionAgent) worker).setSales(value);
        } else if (worker instanceof ByHours) {
            ((ByHours) worker).setHours((int) value);
        }
    }

    public void printPayRoll() {
        for (Worker worker : workers) {
            System.out.println(worker.name + " " + worker.lastName + ": $" + worker.salary);
        }
    }
}

// Clase base Worker
abstract class Worker {
    protected String name;
    protected String lastName;
    protected String Adress;
    protected String DNI;
    protected double salary;
    protected Boss boss;

    public Worker(String name, String lastName, String Adress, String DNI, Boss boss) {
        this.name = name;
        this.lastName = lastName;
        this.Adress = Adress;
        this.DNI = DNI;
        this.boss = boss;
    }

    public void addBoss(Boss boss) {
        this.boss = boss;
    }

    public abstract void calcuSalary();
}

// Clase Boss
class Boss extends Worker {
    public Boss(String name, String lastName, String Adress, String DNI, double salary) {
        super(name, lastName, Adress, DNI, null);
        this.salary = salary;
    }

    @Override
    public void calcuSalary() {
        // El salario del jefe es fijo, no se calcula
    }
}

// Clase Mensuality
class Mensuality extends Worker {
    private double fixedSalary;

    public Mensuality(String name, String lastName, String Adress, String DNI, Boss boss, double fixedSalary) {
        super(name, lastName, Adress, DNI, boss);
        this.fixedSalary = fixedSalary;
    }

    @Override
    public void calcuSalary() {
        this.salary = this.fixedSalary;
    }
}

// Clase CommissionAgent
class CommissionAgent extends Worker {
    private double commissionRate;
    private double sales;

    public CommissionAgent(String name, String lastName, String Adress, String DNI, Boss boss, double commissionRate) {
        super(name, lastName, Adress, DNI, boss);
        this.commissionRate = commissionRate;
        this.sales = 0;
    }

    public void setSales(double sales) {
        this.sales = sales;
        this.calcuSalary();
    }

    @Override
    public void calcuSalary() {
        this.salary = this.sales * this.commissionRate;
    }
}

// Clase ByHours
class ByHours extends Worker {
    private double hourlyRate;
    private double extraHourlyRate;
    private int hours;

    public ByHours(String name, String lastName, String Adress, String DNI, Boss boss, double hourlyRate, double extraHourlyRate) {
        super(name, lastName, Adress, DNI, boss);
        this.hourlyRate = hourlyRate;
        this.extraHourlyRate = extraHourlyRate;
        this.hours = 0;
    }

    public void setHours(int hours) {
        this.hours = hours;
        this.calcuSalary();
    }

    @Override
    public void calcuSalary() {
        if (hours <= 40) {
            this.salary = hours * hourlyRate;
        } else {
            this.salary = (40 * hourlyRate) + ((hours - 40) * extraHourlyRate);
        }
    }
}
