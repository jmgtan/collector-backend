package org.humanitarian.collector.auth.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.digest.DigestUtils;
import org.humanitarian.collector.auth.models.Role;
import org.humanitarian.collector.auth.models.User;
import org.humanitarian.collector.auth.repositories.RoleRepository;
import org.humanitarian.collector.auth.repositories.UserRepository;
import org.humanitarian.collector.exceptions.DuplicateUserException;
import org.humanitarian.collector.exceptions.InvalidLoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.nio.charset.StandardCharsets;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Service
public class UserService {

    private static final String JWT_ISSUER = "collector_backend";

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Value("${jwt.secret}")
    private String jwtSecret;

    @Transactional
    public User registerNewUser(String username, String password, Set<String> roles) throws DuplicateUserException {

        User existingUser = userRepository.findOneByUsername(username);

        if (existingUser != null) {
            throw new DuplicateUserException();
        }

        User u = new User();

        u.setUsername(username);
        u.setPassword(password);

        Set<Role> listOfRoles = new HashSet<>();

        for (String strRoleName : roles) {
            Role r = roleRepository.findOneByName(strRoleName.toUpperCase());
            if (r != null)
                listOfRoles.add(r);
        }

        /**
         * The default role is read access
         */
        if (listOfRoles.size() == 0) {
            listOfRoles.add(roleRepository.findOneByName(Role.ROLE_ANALYST));
        }

        u.setRoles(listOfRoles);

        userRepository.save(u);

        return u;
    }

    public String loginAndGenerateJwtToken(String username, String password) throws InvalidLoginException {
        String shaPassword = DigestUtils.sha256Hex(password);
        User u = userRepository.findOneByUsernameAndPassword(username, shaPassword);

        if (u == null) {
            throw new InvalidLoginException();
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.HOUR_OF_DAY, 1);

        return Jwts.builder()
                .setSubject(String.valueOf(u.getId()))
                .setAudience(u.getUsername())
                .setExpiration(cal.getTime())
                .setIssuer(JWT_ISSUER)
                .setIssuedAt(new Date())
                .signWith(Keys.hmacShaKeyFor(jwtSecret.getBytes(StandardCharsets.UTF_8)))
                .compact()
                ;
    }
}
