package cn.xx.service;


import java.util.List;

public interface AccountService {
    /**
     * 模拟保存账户
     * @param account
     */
    void saveAccount();

    /**
     * 模拟更新账户
     * @param account
     */
    void updateAccount(int i);

    /**
     * 删除账户
     * @param id
     */
    int deleteAccount();
}
