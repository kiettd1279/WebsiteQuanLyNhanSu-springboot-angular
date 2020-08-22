import { Employee } from './employee';

export interface SalaryHistory {
    id: number;
    CountedDate :string;
    WorkDay :number;
    TaxMoney: number;
    RewardMoney:number;
    PublishMoney:number;
    InsurranceMoney:number;
    Salary:number;
    employee :Employee;
}
