package com.user.management.service;


import com.user.management.model.dto.ListOfUsers;
import com.user.management.model.dto.User;

import java.util.List;

public interface UserService {
    ListOfUsers listAllUsers();
    User createUser(User user);
    User updateUser(User user);
    void deleteUser(String userID);
}
