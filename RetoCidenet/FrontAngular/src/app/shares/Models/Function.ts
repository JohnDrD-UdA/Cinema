import { hall } from "./hall";
import { Movie } from "./Movie";

export interface functionM{
    id:number,
    movie:Movie,
    hall:hall,
    date:string,
    active:boolean
}