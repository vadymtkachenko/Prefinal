package ua.nure.tkachenko.Final.web.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ua.nure.tkachenko.Final.db.entity.User;
import ua.nure.tkachenko.Final.db.exception.DataBaseException;
import ua.nure.tkachenko.Final.services.api.UserServiceImpl;
import ua.nure.tkachenko.Final.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Locale;


public class ChangeLanguageCommand extends Command {

    /**
     *
     */
    private static final long serialVersionUID = 4918241008963927523L;
    private static final Logger LOG = LogManager.getLogger(ChangeLanguageCommand.class);

    @Override
    public String execute(HttpServletRequest request) {
        LOG.debug("ChangeLanguageCommand started");
        LOG.debug("Locale now = " + request.getSession().getAttribute("language"));
        LOG.debug("Getting params");
        String localeName = request.getParameter("lan");
        String userUrl = request.getParameter("userUrl");
        LOG.debug("Param now is = " + localeName);
        Locale locale = new Locale(localeName);
        request.getSession().setAttribute("language", locale);
        LOG.debug("Locale set");
        LOG.debug("Redirect");
        LOG.debug(userUrl);

//        User user = (User) request.getSession().getAttribute("user");
//        if (user != null) {
//            user.setLocale(localeName);
//            try {
//                UserServiceImpl.getInstance().updateUserLocale(user, locale);
//            } catch (DataBaseException e) {
//                throw new AppException(e.toString());
//            }
//            request.getSession().setAttribute("user", user);
//            LOG.debug("User " + user.getLogin() + " changed language");
//        }
        return userUrl;
    }
}
