package com.studentcampus.student_module;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashMap;
import java.util.Map;

public class ClockIn extends JFrame implements MouseListener {

    int ID;

    int Information;

    //学生用打卡信息（是否打卡,放在这里便于控制）
    Boolean s11=null;
    Boolean s22=null;

    //打卡按钮1，2
    JButton CI1;
    JButton CI2;

    //教师用打卡信息记录（放这，便于调用）
    Map<String,Integer> Maps1 = null;
    Map<String,Integer> Maps2 = null;

    //教师的打卡信息查看按钮
    JButton Look1;
    JButton Look2;

    //打卡，ID表示学生还是老师（1 or 2），Information表示学生或老师的对应信息（每个老师学生都不一样）
    public ClockIn(int ID,int Information){
        this.ID=ID;
        this.Information=Information;

        //从数据库加载数据
        LoadFile();
        //初始化界面
        initFrame();
        //初始化组件
        initView();
        //窗口居中显示
        this.setLocationRelativeTo(null);
        //显示界面
        this.setVisible(true);

    }

    public void LoadFile(){
        //打卡信息1，2，教师学生通用变量，放最上面
        String s1=null;
        String s2=null;


        //读取学生的正在进行的打卡的信息
        if(ID==0){


            //查询指定学生的正在进行的打卡的信息，用Information
            //JAVA示范,假设从数据库里查询到了指定的信息
            //注意，限制一下，只查询最近的两个
            s1="信息课  9:00-10:00";//课程信息
            s11=false;//该学生是否已经打卡

            s2="电脑课  7:00-8:00";
            s22=true;

            //这个是记录获得的打卡信息有几个，用数据库SQL语句查询获得返回结果统计
            int count=2;

            //根据获取的结果数，调用相应的方法显示在界面上
            if(count==1){
                GetStudentUI(s1,s11);
            }else if(count==2){
                GetStudentUI(s1,s11,s2,s22);
            }else {//没有打卡信息，直接显示无
                JLabel l1=new JLabel("无");
                l1.setBounds(30,30,150,30);
                this.getContentPane().add(l1);
            }

        } else if (ID==1) {



            //查询相关老师的打卡信息
            //JAVA示范,假设从数据库里查询到了指定的信息
            //注意，限制一下，只查询最近的两个
            s1="信息课  9:00-10:00";//课程信息
            Maps1=new HashMap<>();//从服务器获取学生打卡信息，Map类型可以改，键：学生姓名，值：boolean，是or否（打卡）
            //示例，张三未打卡(缺勤)，李四打卡，王五请假，对应0，1，2
            Maps1.put("张三",0);
            Maps1.put("李四",1);
            Maps1.put("王五",2);


            //这个是记录获得的打卡信息有几个，用数据库SQL语句查询获得返回结果统计
            int count=1;

            //根据获取的结果数，调用相应的方法显示在界面上
            if(count==1){
                GetTeacherUI(s1,Maps1);
            }else if(count==2){
                GetTeacherUI(s1,Maps2,s2,Maps2);
            }else {//没有打卡信息，直接显示无
                JLabel l1=new JLabel("无");
                l1.setBounds(30,30,150,30);
                this.getContentPane().add(l1);
            }
        }


    }

    //学生打卡界面，仅1条打卡信息
    public void GetStudentUI(String s1,Boolean s11){
        //显示打卡信息：xx课 xx:xx
        JLabel information=new JLabel(s1);
        information.setBounds(30,30,150,30);
        this.getContentPane().add(information);

        //如果打卡，则显示已打卡
        if(s11){
            //(CIYN:Clock In Yes ,已打卡)
            JLabel CIY1=new JLabel("已经打卡");
            CIY1.setBounds(200,30,150,30);
            this.getContentPane().add(CIY1);
        }else{
            //(CIYN:Clock In No ,未打卡)
            JLabel CIN1=new JLabel("未打卡");
            CIN1.setBounds(200,30,150,30);
            this.getContentPane().add(CIN1);

            //未打卡，添加打卡按钮
            CI1=new JButton("打卡");
            CI1.setBounds(400,30,150,30);
            CI1.addMouseListener(this);
            this.getContentPane().add(CI1);
        }

    }

    //学生打卡界面，2条打卡信息
    public void GetStudentUI(String s1,Boolean s11,String s2,Boolean s22){
        //显示第一打卡信息：xx课 xx:xx
        JLabel information1=new JLabel(s1);
        information1.setBounds(30,30,150,30);
        this.getContentPane().add(information1);

        //如果打卡，则显示已打卡
        if(s11){
            //(CIYN:Clock In Yes ,已打卡)
            JLabel CIY1=new JLabel("已经打卡");
            CIY1.setBounds(200,30,150,30);
            this.getContentPane().add(CIY1);
        }else {
            //(CIYN:Clock In No ,未打卡)
            JLabel CIN1 = new JLabel("未打卡");
            CIN1.setBounds(200, 30, 150, 30);
            this.getContentPane().add(CIN1);

            //未打卡，添加打卡按钮
            CI1 = new JButton("打卡");
            CI1.setBounds(400, 30, 150, 30);
            CI1.addMouseListener(this);
            this.getContentPane().add(CI1);
        }



        //显示第二打卡信息：xx课 xx:xx
        JLabel information2=new JLabel(s2);
        information2.setBounds(30,90,150,30);
        this.getContentPane().add(information2);

        //如果打卡，则显示已打卡
        if(s22){
            //(CIYN:Clock In Yes ,已打卡)
            JLabel CIY2=new JLabel("已经打卡");
            CIY2.setBounds(200,90,150,30);
            this.getContentPane().add(CIY2);
        }else {
            //(CIYN:Clock In No ,未打卡)
            JLabel CIN2 = new JLabel("未打卡");
            CIN2.setBounds(200, 90, 150, 30);
            this.getContentPane().add(CIN2);

            //未打卡，添加打卡按钮
            CI2 = new JButton("打卡");
            CI2.setBounds(400, 90, 150, 30);
            CI2.addMouseListener(this);
            this.getContentPane().add(CI2);
        }

    }

    //教师打卡主界面，仅1条打卡信息
    public void GetTeacherUI(String s1,Map<String,Integer> Maps1){
        //显示打卡信息：xx课 xx:xx
        JLabel information1=new JLabel(s1);
        information1.setBounds(30,30,150,30);
        this.getContentPane().add(information1);

        //查看按钮
        JButton Look1 =new JButton("查看");
        Look1.setBounds(400,30,150,30);
        Look1.addMouseListener(this);
    }

    //教师打卡主界面，2条打卡信息
    public void GetTeacherUI(String s1,Map<String,Integer> Maps1,String s2,Map<String,Integer> Maps2){
        //显示第一条打卡信息：xx课 xx:xx
        JLabel information1=new JLabel(s1);
        information1.setBounds(30,30,150,30);
        this.getContentPane().add(information1);

        //查看按钮
        Look1 =new JButton("查看");
        Look1.setBounds(400,30,150,30);
        Look1.addMouseListener(this);

        //显示第二条打卡信息：xx课 xx:xx
        JLabel information2=new JLabel(s1);
        information2.setBounds(30,90,150,30);
        this.getContentPane().add(information2);

        //查看按钮
        Look2 =new JButton("查看");
        Look2.setBounds(400,90,150,30);
        Look2.addMouseListener(this);

    }

    public void initFrame(){
        this.setBounds(100,100,500,500);
        this.setLayout(null);
        this.setResizable(false);
        this.setTitle("打卡");
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }


    public void initView(){
        //如果是学生
        if(ID==0){
            JLabel Txt = new JLabel("正在进行的打卡:");
            Txt.setBounds(50,50,150,30);
            this.getContentPane().add(Txt);
        }else if(ID==1){
            JLabel Txt = new JLabel("打卡信息查看");
            Txt.setBounds(200,20,150,30);
            this.getContentPane().add(Txt);
        }
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        Object source=e.getSource();
        //打卡的逻辑
        //写入数据库
        //JAVA本地模拟
        if(source==CI1){
            s11=true;//设置为已经打卡
            this.getContentPane().repaint();//刷新界面（可能失败）
        }
        if(source==CI2){
            s22=true;//设置为已经打卡
            this.getContentPane().repaint();//刷新界面（可能失败）
        }
        if(source==Look1){
            LookInformation(1);//打开信息界面
            this.dispose();//关闭目前界面
        }
        if(source==Look2){
            LookInformation(2);//打开信息界面
            this.dispose();//关闭目前界面
        }

    }

    //教师的查看打卡信息界面，i就是查看的是哪个打卡的信息（1 or 2 ，对应Maps1,Maps2）
    public void LookInformation(int i){
        if(i==1){
            new SignInPage();
        }
        else if(i==2){
            new SignInPageTwo();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public static void main(String[] args) {
        new ClockIn(2,1);
    }
}
