package Controller;
import Entity.LoginEntity;
import Model.LoginModel;

public class LoginController {
    public int login(String username, String password){
        int log = allobjectcontroller.login.cekLogin(username, password);
        return log;
    }
}
