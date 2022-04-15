
export interface Profile
{
    id : number;
    pictureUrl : string;
    user : {
        userId : number,
        username : string,
        password : string,
        email : string
    };
    firstName : string;
    middleInit : string;
    lastName : string;
    birthday : string;
    city : string;
    state : string;
    aboutMe : string;
}