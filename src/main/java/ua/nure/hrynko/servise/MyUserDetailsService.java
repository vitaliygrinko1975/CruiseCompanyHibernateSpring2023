package ua.nure.hrynko.servise;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.nure.hrynko.db.dao.MySqlUsersDAO;
import ua.nure.hrynko.db.models.Role;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userDetailsService")
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private MySqlUsersDAO mySqlUsersDAO;

    @Transactional(readOnly = true)
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

        ua.nure.hrynko.db.models.User user = mySqlUsersDAO.findUserByLogin(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
        return buildUserForAuthentication(user, authorities);
    }

    // Converts  ua.nure.hrynko.db.models.User user to
    // org.springframework.security.core.userdetails.User
    private User buildUserForAuthentication(ua.nure.hrynko.db.models.User user, List<GrantedAuthority> authorities) {
        return new User(user.getLogin(), user.getPassword(), true,
                true, true, true, authorities);
    }

    private List<GrantedAuthority> buildUserAuthority(Role role) {

        Set<GrantedAuthority> setAuths = new HashSet<>();

        setAuths.add(new SimpleGrantedAuthority(role.getName()));

        return new ArrayList<>(setAuths);
    }

}