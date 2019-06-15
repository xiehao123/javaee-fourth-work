package cn.bjtu.bjtu.demofourth.services;

import cn.bjtu.bjtu.demofourth.dao.UserRepository;
import cn.bjtu.bjtu.demofourth.domain.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public Mono<User> findById(String id) {
        return userRepository.findById(id);
    }
    @Override
    public Flux<User> findAll() {
        return userRepository.findAll();
    }
    @Override
    public Mono<User> save(User user) {
        return userRepository.save(user);
    }
    @Override
    public Mono<Void> deleteById(String id) {
        return userRepository.deleteById(id);
    }

    @Override
    public Mono<User> login(User user) {
        return userRepository.findByNameAndPassword(user.getName(),user.getPassword());
    }
}