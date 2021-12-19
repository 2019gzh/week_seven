import com.gzh.domain.Account;
import com.gzh.service.AccountService;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

public class AccountServiceTest {
    private AccountService accountService;
    @Before
    public void init() throws IOException {
        accountService = new AccountService();
    }

    @Test
    public void testInsert_1() {
        Date date = new Date();
        accountService.insert(new Account("1", "zhangsan", 100, date, date));
    }

    @Test
    public void testInsert_2() {
        Date date = new Date();
        accountService.insert(new Account("2", "lisi", 50, date, date));
    }

    @Test
    public void testFindAll(){
        List<Account> accounts = accountService.findAll();
        System.out.println(accounts);
    }

    @Test
    public void testSelectByPrimaryKey() {
        Account account = accountService.selectByPrimaryKey("1");
        System.out.println(account);
    }

    @Test
    public void testUpdateByPrimaryKey() {
        Date date = new Date();
        accountService.updateByPrimaryKey(new Account("1", "wangwu", 200, date, date));
    }

    @Test
    public void testtransfer() {
        accountService.transfer("1","2", 10);
    }

    @Test
    public void testDeleteByPrimaryKey() {
        accountService.deleteByPrimaryKey("1");
    }

}
