package com.lyh.service;

import com.lyh.bean.Customer;
import com.lyh.bean.CustomerData;
import com.lyh.util.TextUtil;

import java.util.List;
import java.util.Scanner;

//此类完成客户的所有业务（增删改查）
public class CustomerService2 {

    private List<Customer> customerList;
    private Customer currentcustomer;
    private Scanner scanner;
    public void checkPwd(String cardid, String cardPwd){
        CustomerData customerData = CustomerData.getInstance();
        customerList = customerData.getCustomerList();
        //用拿到的账户名和密码跟集合中的作比较
        System.out.println("cardid = " + cardid);
        System.out.println("cardPwd = " + cardPwd);
        for (Customer customer : customerList) {
            if(customer.getAccount().equals(cardid) && customer.getPassword().equals(cardPwd)){
                currentcustomer = customer;
                //账户密码正确
                System.out.println("欢迎"+customer.getCname()+"顾客登陆！请注意安全");
                TextUtil.oneLeveOption();
                scanner = new Scanner(System.in);
                //选择输入
                String option = scanner.nextLine();
                oneOption(option);//用户功能选择的封装
            }
        }
    }

    //用户功能选择的封装
    private void oneOption(String option) {
        switch (option){
            case "1":
                System.out.println("余额查询");
                selectMoney();
                goOneHome();
                break;
            case "2":
                System.out.println("取款");
                TextUtil.twoLeveOption();//取款页面
                twoOption();//取款方法
                goOneHome();
                break;
            case "3":
                System.out.println("转账");
                truanMoney();
                goOneHome();
                break;
            case "4":
                System.out.println("存款");
                TextUtil.threeLeveOption();//存款的界面
                getMoney();
                goOneHome();
                break;
            case "5":
                exitcard();
                break;
            default:
                System.out.println("您输入的功能有误");
                break;
        }
    }
    //退卡
    private void exitcard() {
        System.out.println("您是否继续操作yes/no(Y/N)");
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if(s.equalsIgnoreCase("y")){
            TextUtil.welcome();
        }
        if(s.equalsIgnoreCase("n")){
            System.out.println("退卡成功");
        }
    }

    //转账
    private void truanMoney() {
        System.out.println("请输入对方的卡号：");
        scanner = new Scanner(System.in);
        String otherAccount = scanner.nextLine();
        System.out.println("请输入您需要转账的金额：");
        double goMoney = scanner.nextDouble();
        double money = currentcustomer.getMoney()-goMoney;//自己转账后剩下的钱
        Customer other = null;
        for (Customer customer : customerList) {
            if(customer.getAccount().equals(otherAccount)){
                other=customer;
            }
        }
        double otherMoney = other.getMoney() + goMoney;//转账后剩余的钱
        //自己和别人的钱余额都更新一下
        currentcustomer.setMoney(money);
        other.setMoney(otherMoney);
    }

    //余额查询
    private void selectMoney() {
        double money = currentcustomer.getMoney();
        System.out.println("你的余额是 " + money);

    }
    //取款类
    private void twoOption() {
        scanner = new Scanner(System.in);
        String quMoney = scanner.nextLine();
        switch(quMoney){
            case "1":
                double a=100;
                System.out.println("请及时拿走现金100元");
                if(a<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-a)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "2":
                double b=200;
                System.out.println("请及时拿走现金200元");
                if(b<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-b)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "3":
                double c=300;
                System.out.println("请及时拿走现金300元");
                if(c<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-c)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "4":
                double d=500;
                System.out.println("请及时拿走现金500元");
                if(d<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-d)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "5":
                double e=800;
                System.out.println("请及时拿走现金800元");
                if(e<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-e)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "6":
                double f=1000;
                System.out.println("请及时拿走现金1000元");
                if(f<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-f)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "7":
                double g=2000;
                System.out.println("请及时拿走现金2000元");
                if(g<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-g)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            case "8":
                System.out.println("其他");
                Scanner qita = new Scanner(System.in);
                double v = qita.nextDouble();
                if(v<currentcustomer.getMoney()){
                    System.out.println("****************");
                    System.out.println("您的余额为"+(currentcustomer.getMoney()-v)+"元");
                }else{
                    System.out.println("余额不足，请选择其他业务");
                }
                break;
            default:
                System.out.println("请输入正确的序号");
                break;
        }
    }


    //存款
    private void getMoney() {
        scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        switch (s) {
            case "1":
                int a = 100;
                System.out.println("存入现金100元");
                System.out.println("****************");
                double v1 = currentcustomer.getMoney() + a;
                System.out.println("您的余额为" + v1+ "元");
                currentcustomer.setMoney(v1);
                break;
            case "2":
                double b = 1000;
                System.out.println("存入现金1000元");
                System.out.println("****************");
                double v2 = currentcustomer.getMoney() + b;
                System.out.println("您的余额为" + v2 + "元");
                break;
            case "3":
                double c = 1500;
                System.out.println("存入现金1500元");
                System.out.println("****************");
                double v3 = currentcustomer.getMoney() + c;
                System.out.println("您的余额为" + v3 + "元");
                break;
            case "4":
                System.out.println("请输入你要存的金额：");
                int i = scanner.nextInt();
                if(i%100==0){
                    System.out.println("****************");
                    double v = currentcustomer.getMoney() + i;
                    System.out.println("您的余额为" + v + "元");
                    currentcustomer.setMoney(v);
                }else{
                    System.out.println("只能存整数的钱");
                }
                break;
        }
    }

    //选择功能之后返回输入功能
    private void goOneHome() {
        TextUtil.oneLeveOption();
        scanner = new Scanner(System.in);
        String option = scanner.nextLine();
        System.out.println("option= " + option);
        oneOption(option);
    }
}