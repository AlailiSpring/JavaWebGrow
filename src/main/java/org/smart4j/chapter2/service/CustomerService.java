package org.smart4j.chapter2.service;

import org.smart4j.chapter2.helper.DatabaseHelper;
import org.smart4j.chapter2.model.Customer;
import org.smart4j.chapter2.util.PropsUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.regex.PatternSyntaxException;

/**
 * 提供客户数据服务
 */
public class CustomerService {
    /**
     * 获取客户列表
     *
     * @param keyword
     * @return
     */
    public List<Customer> getCustomerList(String keyword) {
        //TODO
/*        Connection conn = null;
        try {
            List<Customer> customerList = new ArrayList<Customer>();
            String sql = "SELECT * FROM CUSTOMER";
            conn = DatabaseHelper.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getLong("id"));
                customer.setContact(rs.getString("contact"));
                customer.setEmail(rs.getString("email"));
                customer.setName(rs.getString("name"));
                customer.setRemark(rs.getString("remark"));
                customer.setTelephone(rs.getString("telephone"));
                customerList.add(customer);
            }*/
        /*change the way how the code up works*/
 /*       Connection conn = DatabaseHelper.getConnection();
        List<Customer> customerList = new ArrayList<Customer>();
        try {
            String sql = "SELECT * FROM CUSTOMER";
            customerList = DatabaseHelper.queryEntityList(conn, Customer.class, sql);
        } finally {
*//*
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
*//*
            DatabaseHelper.closeConnection(conn);
        }
        return customerList;
*/
        //修改的代码 20171214 Alaili Spring
        String sql = "SELECT * FROM CUSTOMER";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /**
     * 获取客户
     *
     * @param id
     * @return
     */
    public Customer getCustomer(long id) {
        //TODO
        String sql = "SELECT * FROM CUSTOMER WHERE ID=?";
        return DatabaseHelper.queryEntity(Customer.class,sql,id);
    }

    /**
     * 创建客户
     *
     * @param fieldMap
     * @return
     */
    public boolean createCustomer(Map<String, Object> fieldMap) {
        //TODO
        return DatabaseHelper.insertEntity(Customer.class,fieldMap);
    }

    /**
     * 更新客户
     *
     * @param id
     * @param fieldMap
     * @return
     */
    public boolean updateCustomer(Long id, Map<String, Object> fieldMap) {
        //TODO
        return DatabaseHelper.updateEntity(Customer.class,id,fieldMap);
    }

    /**
     * 删除客户
     *
     * @param id
     * @return
     */
    public boolean deleteCustomer(long id) {
        //TODO
        return DatabaseHelper.deleteEntity(Customer.class,id);
    }
}
