package modeles;

import javax.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private long idUser;
    private String username;
    @Column(name = "hash_password")
    private String hashPassword;
    private String salt;
    @Column(name = "is_admin")
    private  boolean isAdmin;

    public User() {
    }

    public User(long idUser, String username, String hashPassword) {
        this.idUser = idUser;
        this.username = username;
        this.hashPassword = hashPassword;
    }

    public User(long idUser, String username, String hashPassword, String salt, boolean isAdmin) {
        this.idUser = idUser;
        this.username = username;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.isAdmin = isAdmin;
    }

    public User(String username, String hashPassword, String salt, boolean isAdmin) {
        this.username = username;
        this.hashPassword = hashPassword;
        this.salt = salt;
        this.isAdmin = isAdmin;
    }

    public User(String username, String hashPassword, boolean isAdmin) {
        this.username = username;
        this.hashPassword = hashPassword;
        this.isAdmin = isAdmin;
    }

    public User(String username, String hashPassword, String salt) {
        this.username = username;
        this.hashPassword = hashPassword;
        this.salt = salt;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashPassword() {
        return hashPassword;
    }

    public void setHashPassword(String hashPassword) {
        this.hashPassword = hashPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", username='" + username + '\'' +
                ", hashPassword='" + hashPassword + '\'' +
                ", salt='" + salt + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
