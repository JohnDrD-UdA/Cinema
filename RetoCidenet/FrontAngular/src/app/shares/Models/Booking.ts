import { customer } from "./customer";

export interface Booking{
    id:number,
    customer:customer|null
    functionM:Function,
    status:string,
    chairLocation:string
}