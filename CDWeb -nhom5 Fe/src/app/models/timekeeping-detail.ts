import { Employee } from './employee';

export interface TimekeepingDetail {
    id:number;
    employeeId:number;
    timeStart:string;
    timeEnd:string;
    timeWorking:number;
    timeKeepingId:number;
    shift:string,
    status:number;
    employee :Employee;
}
