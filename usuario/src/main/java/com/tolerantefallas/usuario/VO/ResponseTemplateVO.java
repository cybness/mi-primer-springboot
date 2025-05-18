package com.tolerantefallas.usuario.VO;
import com.tolerantefallas.usuario.entity.Userz;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private Userz user;
    private Department department;

}
