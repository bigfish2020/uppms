package design.uppms.service;

import design.uppms.model.dto.UserDTO;

public interface LoginRegisteService {
    //登录
    public boolean Login(UserDTO userDTO);

    //信息提交
    public UserDTO submit(UserDTO userDTO);

    //注册
    public boolean registeUser(UserDTO userDTO);




}
