package com.tolerantefallas.usuario.service;

import com.tolerantefallas.usuario.VO.Department;
import com.tolerantefallas.usuario.VO.ResponseTemplateVO;
import com.tolerantefallas.usuario.entity.Userz;
import com.tolerantefallas.usuario.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public Userz saveUser(Userz user) {
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("Inside getUserWithDepartment of UserService");

        ResponseTemplateVO vo = new ResponseTemplateVO();
        Userz user = userRepository.findByUserId(userId);

        if (user == null) {
            log.error("User not found with ID: {}", userId);
            throw new RuntimeException("User not found");
        }

        vo.setUser(user);

        if (user.getDepartmentId() == null) {
            log.warn("User with ID {} has no departmentId", userId);
            vo.setDepartment(null);
            return vo;
        }

        try {
            Department department = restTemplate.getForObject(
                    "http://departamentos/departments/" + user.getDepartmentId(),
                    Department.class
            );
            vo.setDepartment(department);
        } catch (Exception e) {
            log.error("Error fetching department for departmentId {}: {}", user.getDepartmentId(), e.getMessage());
            vo.setDepartment(null);
        }

        return vo;
    }

}