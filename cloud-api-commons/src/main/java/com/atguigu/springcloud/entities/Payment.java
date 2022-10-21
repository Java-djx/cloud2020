package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author 86166
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable
{


    private Long id;

    private String serial;
}
