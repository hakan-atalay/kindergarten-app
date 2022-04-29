package controller;

import DAO.UserDAO;
import entity.User;
import java.io.Serializable;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;

@Named
@SessionScoped
public class LoginController implements Serializable {

    private User user;
    private UserDAO uDao;

    public String login() {
        if (this.user.getUsername().equals(this.user.getUsername()) && this.user.getUser_password().equals(this.user.getUser_password())) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("valid_user", this.user);
            return "/panel/ogrenciler/list?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Hatalı kullanıcı adı veya şifre"));
            return "/login";
        }
    }

    public UserDAO getuDao() {
        if (this.uDao == null) {
            this.uDao = new UserDAO();
        }
        return uDao;
    }

    public void setuDao(UserDAO uDao) {
        this.uDao = uDao;
    }

    public User getUser() {
        if (this.user == null) {
            this.user = new User();
        }
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
