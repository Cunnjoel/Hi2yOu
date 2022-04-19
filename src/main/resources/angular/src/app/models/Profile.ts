import { User } from "./User";

export interface Profile
{
    id : number;
    pictureUrl : string;
    user : User;
    firstName : string;
    middleInit : string;
    lastName : string;
    birthday : string;
    city : string;
    state : string;
    aboutMe : string;
}