package design.uppms.service;

import design.uppms.model.dto.UserDTO;
import design.uppms.model.vo.UserVO;

public interface LoginRegisteService {
    //登录

    //信息提交
    public UserDTO submit(UserDTO userDTO);

    //注册
    public boolean registeUser(UserDTO userDTO);




}
