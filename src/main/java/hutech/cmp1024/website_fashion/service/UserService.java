package hutech.cmp1024.website_fashion.service;



import hutech.cmp1024.website_fashion.entity.User;
import hutech.cmp1024.website_fashion.repository.IRoleRepository;
import hutech.cmp1024.website_fashion.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private IUserRepository userRepository;

    @Autowired
    private IRoleRepository roleRepository;

    public void save(User user){
        userRepository.save(user);
        Long userId = userRepository.getUserIdByUsername(user.getUsername());
        Long roleId = roleRepository.getRoleIdByName("USER");
        if(roleId != 0 && userId != 0){
            userRepository.addRoleUser(userId, roleId);
        }
    }
}
