package com.changhongit.facedemo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QRCode implements Serializable {

    private static final long serialVersionUUD=1234567890L;

    private String code;

    private String file;
}
