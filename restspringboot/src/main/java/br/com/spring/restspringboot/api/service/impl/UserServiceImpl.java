package br.com.spring.restspringboot.api.service.impl;

import br.com.spring.restspringboot.api.entity.UserEntity;
import br.com.spring.restspringboot.api.model.UserModel;
import br.com.spring.restspringboot.api.repository.UserDAO;
import br.com.spring.restspringboot.api.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserEntity> getUsers() {
        List<UserModel> userModelList =  userDAO.getUsers();
        if(userModelList != null && !userModelList.isEmpty()){
            List<UserEntity> response = new ArrayList<>();

            userModelList.forEach(
                model -> {
                    UserEntity userEntity = new UserEntity();
                    BeanUtils.copyProperties(model, userEntity);
                    response.add(userEntity);
                }
            );
            return response;
        }
        return new ArrayList<>();
    }
}
