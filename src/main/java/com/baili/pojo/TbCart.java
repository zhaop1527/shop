package com.baili.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Repository
public class TbCart implements Serializable {
    private static final long serialVersionUID = 1L;
    private Integer cartId;
    private Integer goodsId;
    private Integer userId;
    private Integer goodsNum;
}
