import { Timestamp } from "rxjs";

export interface Post{
    id : number;
    message : string;
    picture : string;
    users : Array<object>;
    date : Timestamp<Date>;
    user : {
        id : number;
        username : string;
        password : string;
        email : string
    }
}