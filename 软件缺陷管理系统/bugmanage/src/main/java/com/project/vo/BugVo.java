package com.project.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class BugVo {

    private Integer id;

    private String bug_title;

    private Integer status;

    private Integer type_id;

    private String bug_describe;

    private Integer performance;

    private Date expected_time;

    private Date create_time;

    private Date end_time;

    private Integer user_id;

    private String bug_name;

    private String user_name;

    private String real_name;

    private Integer role;

    private Integer project_id;

    private String project_name;

    private Integer technology_id;

    private String technology_name;

    private String bug_word;

    private String bug_result;

    private String withdraw_reason;

    private Integer test_id;

    private String test_name;

    private String project_manager;
}
