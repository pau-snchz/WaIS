
package com.mycompany.modules.tables;

public class Accounts {
    private final int accID;
    private final String fullName;
    private final String email;
    private final String contactInfo;
    private final String password;

    public Accounts(int id, String name, String emailAdd, String phoneNo, String pass) {
        this.accID = id;
        this.fullName = name;
        this.email = emailAdd;
        this.contactInfo = phoneNo;
        this.password = pass;
    }

    public int getAccID() {
        return accID;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public String getPassword() {
        return password;
    }

    // toString method
    @Override
    public String toString() {
        return "Account{" +
                "accID=" + accID +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", contactInfo='" + contactInfo + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
