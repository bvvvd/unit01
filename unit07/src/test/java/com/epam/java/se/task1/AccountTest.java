package com.epam.java.se.task1;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class AccountTest {
    private Account account;
    private Account anotherAccount;

    @Before
    public void initAccount() {
        this.account = new Account(0,100);
        this.anotherAccount = new Account(0,100);
    }

    @Test
    public void testCreateAccountWithSpecifiedIdAndBalance() {
        assertThat(account.getID() == 0 && account.getBalance() == 100, is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCreateAccountWithNegativeBalanceThrowsIllegalArgumentException() {
        final Account account = new Account(0, -1);
    }

    @Test
    public void testDepositMethodWorksCorrectly() {
        account.deposit(10000);

        assertThat(account.getID() == 0 && account.getBalance() == 10100, is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDepositMethodWithNegativeAmountThrowsIllegalArgumentException() {
        account.deposit(-100);
    }

    @Test
    public void testWithdrawMethodWorksCorrectly() {
        account.withdraw(100);

        assertThat(account.getID() == 0 && account.getBalance() == 0, is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testWithdrawMethodWithNegativeAmountThrowsIllegalArgumentException() {
        account.deposit(-100);
    }

    @Test
    public void testEqualsWithEqualsAccounts() {
        assertThat(account.equals(anotherAccount), is(true));
    }

    @Test
    public void testEqualsAccountsHaveEqualsHashCodes() {
        assertThat(account.hashCode() == anotherAccount.hashCode(), is(true));
    }

    @Test
    public void testEqualsAndHashCodeWithEqualsAccounts() {
        assertThat(account.equals(anotherAccount) && (account.hashCode() == anotherAccount.hashCode()), is(true));
    }

    @Test
    public void testEqualsWithNotEqualsAccounts() {
        account.deposit(10);

        assertThat(account.equals(anotherAccount), is(false));
    }

    @Test
    public void testAccountIsSelfEquals() {
        assertThat(account.equals(account), is(true));
    }

    @Test
    public void testEqualsWithNullArgument() {
        assertThat(account.equals(null), is(false));
    }

    @Test
    public void testEqualsWithWrongClassObjectArgument() {
        assertThat(account.equals(new Object()), is(false));
    }

}
