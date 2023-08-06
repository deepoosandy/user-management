package com.user.management.service;


import com.user.management.model.domain.UserDetails;
import com.user.management.model.dto.Address;
import com.user.management.model.dto.ListOfUsers;
import com.user.management.model.dto.User;
import com.user.management.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ListOfUsers listAllUsers() {
        List<UserDetails> allUsers = userRepository.findAll();
        ListOfUsers listOfUsers = new ListOfUsers();
        allUsers.forEach(userDetails -> listOfUsers.add(mapUserEntityToUserDto(userDetails)));
        return listOfUsers;
    }

    private List<Address> mapAddressEntityToAddressDto(List<com.user.management.model.domain.Address> addressEntityList) {
        return addressEntityList.stream().map(address ->
                Address.builder().addressLine1(address.getAddressLine1())
                        .addressLine2(address.getAddressLine2()).city(address.getCity()).country(address.getCountry())
                        .pincode(address.getPincode()).state(address.getState()).build()).collect(Collectors.toList());
    }

    private User mapUserEntityToUserDto(UserDetails userDetails) {
        List<Address> addressList = mapAddressEntityToAddressDto(userDetails.getAddressList());
        return User.builder().firstName(userDetails.getFirstName())
                .lastName(userDetails.getLastName()).roleId(userDetails.getRoles()).
                userEmailId(userDetails.getUserEmailId()).userId(userDetails.getUserId()).address(addressList).build();
    }

    private List<com.user.management.model.domain.Address> mapAddressDtoToAddressEntity(List<Address> addressDtoList,  UserDetails userDetailsEntity) {
        return addressDtoList.stream().map(address -> {
                    com.user.management.model.domain.Address addressEntity = new com.user.management.model.domain.Address();
                    addressEntity.setAddressLine1(address.getAddressLine1());
                    addressEntity.setAddressLine2(address.getAddressLine2());
                    addressEntity.setCity(address.getCity());
                    addressEntity.setCountry(address.getCountry());
                    addressEntity.setPincode(address.getPincode());
                    addressEntity.setState(address.getState());
                    addressEntity.setUser(userDetailsEntity);
                    return addressEntity;
                }
        ).collect(Collectors.toList());
    }

    private UserDetails mapUserDtoToUserDetailsEntity(User user) {
        UserDetails userDetailsEntity= new UserDetails();
        userDetailsEntity.setFirstName(user.getFirstName());
        userDetailsEntity.setLastName(user.getLastName());
        userDetailsEntity.setRoles(user.getRoleId());
        userDetailsEntity.setUserEmailId(user.getUserEmailId());
        userDetailsEntity.setUserId(user.getUserId());
        userDetailsEntity.setUserPassword(user.getUserPassword());
        List<com.user.management.model.domain.Address> addressList = mapAddressDtoToAddressEntity(user.getAddress(),userDetailsEntity);
        userDetailsEntity.setAddressList(addressList);
        return userDetailsEntity;
    }

    @Override
    public User createUser(User user) {
        userRepository.save(mapUserDtoToUserDetailsEntity(user));
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String userID) {

    }
}
