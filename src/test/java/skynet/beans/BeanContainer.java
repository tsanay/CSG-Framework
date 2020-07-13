package skynet.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BeanContainer {
    @Autowired
    public DashboardPage dashboard;

    @Autowired
    public LoginPage login;

    @Autowired
    public CommonPage common;

    @Autowired
    public ResidentPage resident;

    @Autowired
    public DatabaseConnection conn;

}
