package com.zk.roboweb.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
public class Model {
    private Integer id;

    private String modelName;

    private String modelType;

    private String coverImg;

    private String uploadUser;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm", timezone = "GMT+8")
    private Date uploadTime;

    private String fileFormat;

    private Integer fileSize;

    private Integer downloadTimes;

}