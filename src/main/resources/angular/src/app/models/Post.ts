import { Timestamp } from "rxjs";

export interface Post{
    id : number;
    message : string;
    pictureURL : string;
    users : Array<object>;
    date : Timestamp<Date>;
    user : {
        userId : number;
        username : string;
        password : string;
        email : string
    }
}