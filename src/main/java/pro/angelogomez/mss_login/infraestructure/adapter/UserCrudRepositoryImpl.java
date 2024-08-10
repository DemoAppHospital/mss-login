package pro.angelogomez.mss_login.infraestructure.adapter;

import org.springframework.stereotype.Repository;
import pro.angelogomez.mss_login.domain.model.User;
import pro.angelogomez.mss_login.domain.port.IUserRepository;
import pro.angelogomez.mss_login.infraestructure.mapper.UserMapper;

@Repository
public class UserCrudRepositoryImpl implements IUserRepository {
    private final IUserCrudRepository iUserCrudRepository;
    private final UserMapper userMapper;

    public UserCrudRepositoryImpl(IUserCrudRepository iUserCrudRepository, UserMapper userMapper) {
        this.iUserCrudRepository = iUserCrudRepository;
        this.userMapper = userMapper;
    }

    @Override
    public User save(User user) {

        return userMapper.toUser(iUserCrudRepository.save(userMapper.toUserEntity(user)));
    }

    @Override
    public Iterable<User> findAll() {
        return userMapper.toUsers(iUserCrudRepository.findAll());
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.toUser(iUserCrudRepository.findByEmail(email).orElseThrow(
                () -> new RuntimeException("User not registered whit this email: " + email + ".")
        ));
    }

    @Override
    public User findById(Integer id) {

        return userMapper.toUser(iUserCrudRepository.findById(id).get());
    }
}
