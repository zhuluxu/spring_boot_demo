package com.example.demo.entity.generator.model;

import java.util.Date;

public class UserInfoRoleTest {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_role_test.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_role_test.user_account
     *
     * @mbg.generated
     */
    private String userAccount;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_role_test.user_name
     *
     * @mbg.generated
     */
    private String userName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_role_test.create_time
     *
     * @mbg.generated
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_info_role_test.update_time
     *
     * @mbg.generated
     */
    private Date updateTime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_role_test.id
     *
     * @return the value of user_info_role_test.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_role_test.id
     *
     * @param id the value for user_info_role_test.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_role_test.user_account
     *
     * @return the value of user_info_role_test.user_account
     *
     * @mbg.generated
     */
    public String getUserAccount() {
        return userAccount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_role_test.user_account
     *
     * @param userAccount the value for user_info_role_test.user_account
     *
     * @mbg.generated
     */
    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount == null ? null : userAccount.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_role_test.user_name
     *
     * @return the value of user_info_role_test.user_name
     *
     * @mbg.generated
     */
    public String getUserName() {
        return userName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_role_test.user_name
     *
     * @param userName the value for user_info_role_test.user_name
     *
     * @mbg.generated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_role_test.create_time
     *
     * @return the value of user_info_role_test.create_time
     *
     * @mbg.generated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_role_test.create_time
     *
     * @param createTime the value for user_info_role_test.create_time
     *
     * @mbg.generated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_info_role_test.update_time
     *
     * @return the value of user_info_role_test.update_time
     *
     * @mbg.generated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_info_role_test.update_time
     *
     * @param updateTime the value for user_info_role_test.update_time
     *
     * @mbg.generated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}