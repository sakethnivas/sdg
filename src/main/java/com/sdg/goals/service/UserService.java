package com.sdg.goals.service;

import java.util.List;

import com.sdg.goals.dto.UserDTO;

public interface UserService {

    
   
public UserDTO getUserById(Integer id);
    
    public UserDTO getUserByUsername(String username);
    
    public boolean isUserAuthorized(String username, String password);
    
    public UserDTO createUser(UserDTO userDTO);
    
    public void deleteUserById(Integer id);
    
    public List<UserDTO> getAllUsers();
    
    public UserDTO updateUser(Integer id, UserDTO userDTO);
}
