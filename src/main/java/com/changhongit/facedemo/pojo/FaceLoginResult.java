package com.changhongit.facedemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FaceLoginResult implements Serializable {
    private static final long serialVersionUID=23456789l;


    private String state;

    private String token;

    private String userID;



}


