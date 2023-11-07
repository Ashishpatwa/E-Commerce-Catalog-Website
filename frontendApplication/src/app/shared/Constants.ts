export class Constants{


    //Regex
    public static nameRegex: string = "[a-zA-Z]*";
    public static passwordPattern: string =  "[/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/]";
    public static gmailPattern: "[/^[a-zA-Z0-9._%+-]+@gmail\.com$/]";
    public static rollNumberRegex: string = "^[e0-9]{10,10}$";


}